package com.github.jkschoen.jsma.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.junit.Test;

import com.github.jkschoen.jsma.model.Album;
import com.github.jkschoen.jsma.model.AlbumStats;
import com.github.jkschoen.jsma.model.AlbumTemplate;
import com.github.jkschoen.jsma.model.Category;
import com.github.jkschoen.jsma.model.Comment;
import com.github.jkschoen.jsma.model.Community;
import com.github.jkschoen.jsma.model.Coupon;
import com.github.jkschoen.jsma.model.Family;
import com.github.jkschoen.jsma.model.Fan;
import com.github.jkschoen.jsma.model.Featured;
import com.github.jkschoen.jsma.model.Friend;
import com.github.jkschoen.jsma.model.Image;
import com.github.jkschoen.jsma.model.ImageEXIF;
import com.github.jkschoen.jsma.model.ImageStats;
import com.github.jkschoen.jsma.model.Printmark;
import com.github.jkschoen.jsma.model.Template;
import com.github.jkschoen.jsma.model.Watermark;

public class ResponseTest {
	
	private static ObjectMapper MAPPER = new ObjectMapper();
	
	static {
		MAPPER.setAnnotationIntrospector(new JaxbAnnotationIntrospector());
		MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
	}

	@Test
	public void testSMResponse() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"stat\":\"ok\",\"method\":\"smugmug.albums.delete\"}";
		SMResponse value = MAPPER.readValue(json, SMResponse.class);
		SMResponse expected = new SMResponse("ok", "smugmug.albums.delete");
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.getInfo\",\"Album\": {\"id\": 1234,\"Key\": \"xCXXu\",\"Backprinting\": \"\",\"CanRank\": true,\"Category\": {\"id\": 0,\"Name\": \"Other\"},\"Clean\": false,\"ColorCorrection\": 0,\"Comments\": true,\"Description\": \"Photos from my party.\",\"EXIF\": true,\"External\": false,\"FamilyEdit\": true,\"FriendEdit\": true,\"Geography\": false,\"Header\": true,\"HideOwner\": false,\"ImageCount\": 20,\"Larges\": true,\"LastUpdated\": \"\",\"NiceName\": \"My-Birthday-2008\",\"Originals\": false,\"Password\": \"1973\",\"PasswordHint\": \"What year was I born ?\",\"Position\": 1,\"Printable\": true,\"ProofDays\": 1,\"Protected\": false,\"Public\": false,\"Share\": true,\"SmugSearchable\": true,\"SortDirection\": false,\"SortMethod\": \"Position\",\"SquareThumbs\": true,\"Template\": {\"id\": 0},\"Title\": \"My Birthday 2008\",\"Type\": \"Album\",\"URL\": \"http://fred.smugmug.com/Other/My-Birthday-2008/1234_xCXXu\",\"UnsharpAmount\": 0.2,\"UnsharpRadius\": 1,\"UnsharpSigma\": 1,\"UnsharpThreshold\": 0.05,\"UploadKey\": \"\",\"Watermark\": {\"id\": 0,\"Name\": \"SmugMug\"},\"Watermarking\": false,\"WorldSearchable\": true,\"XLarges\": true,\"X2Larges\": true,\"X3Larges\": true}}";
		AlbumResponse value = MAPPER.readValue(json, AlbumResponse.class);
		Album album = new Album(1234, "xCXXu", "", true, new Category(0, "Other"),
				false, 0, true, "Photos from my party.", true, false,
				true, true, false, true, false, 20, true, "", 
				"My-Birthday-2008", false, "1973", 
				"What year was I born ?", 1, true, 1, false, false, 
				true, true,  false, "Position", true, new Template(0), "My Birthday 2008",
				"Album", "http://fred.smugmug.com/Other/My-Birthday-2008/1234_xCXXu",
				0.2f, 1f, 1f, 0.05f, "", new Watermark(0, "SmugMug"),
				false, true, true, true, true);
		AlbumResponse expected = new AlbumResponse("ok", "smugmug.albums.getInfo", album);
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.get\",\"Albums\": [{\"id\": 1234,\"Key\": \"xCXXu\",\"Category\":{\"id\": 0,\"Name\": \"Other\"},\"Title\": \"My Birthday 2008\"}]}";
		AlbumsResponse value = MAPPER.readValue(json, AlbumsResponse.class);
		List<Album> list = new ArrayList<Album>();
		list.add(new Album(1234, "xCXXu", new Category(0, "Other"),"My Birthday 2008" ));
		AlbumsResponse expected = new AlbumsResponse("ok", "smugmug.albums.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumStatsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.getStats\",\"Album\": {\"id\": 1234,\"Key\": \"xCXXu\",\"Bytes\": 11583635,\"Hits\": 46,\"Large\": 10,\"Medium\": 15,\"Original\": 4,\"Small\": 10,\"X2Large\": 0,\"X3Large\": 3,\"XLarge\": 4}}";
		AlbumStatsResponse value = MAPPER.readValue(json, AlbumStatsResponse.class);
		AlbumStatsResponse expected = new AlbumStatsResponse("ok", "smugmug.albums.getStats", new AlbumStats(1234, "xCXXu", 11583635, 46, 10, 15, 4, 10, 0, 3, 4)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumTemplateResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albumtemplates.changeSettings\",\"AlbumTemplate\": {\"id\": 1234}}";
		AlbumTemplateResponse value = MAPPER.readValue(json, AlbumTemplateResponse.class);
		AlbumTemplateResponse expected = new AlbumTemplateResponse("ok", "smugmug.albumtemplates.changeSettings", new AlbumTemplate(1234));
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumTemplatesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albumtemplates.get\",\"AlbumTemplates\": [{\"id\": 2,\"Name\": \"smugmug default\",\"Backprinting\": \"\",\"CanRank\": true,\"Clean\": false,\"ColorCorrection\": 2,\"Comments\": true,\"Community\": {\"id\": 0},\"EXIF\": true,\"External\": true,\"FamilyEdit\": false,\"Filenames\": false,\"FriendEdit\": false,\"Geography\": true,\"Header\": false,\"HideOwner\": false,\"InterceptShipping\": 2,\"Larges\": true,\"Originals\": true,\"PackagingBranding\": true,\"Password\": \"\",\"PasswordHint\": \"\",\"Printable\": true,\"Printmark\": {\"id\": 0},\"ProofDays\": 0,\"Protected\": false,\"Public\": true,\"Share\": true,\"SmugSearchable\": true,\"SortDirection\": false,\"SortMethod\": \"Position\",\"SquareThumbs\": true,\"Template\": {\"id\": 0},\"UnsharpAmount\": 0.2,\"UnsharpRadius\": 1,\"UnsharpSigma\": 1,\"UnsharpThreshold\": 0.05,\"Watermark\": {\"id\": 0,\"Name\": \"SmugMug\"},\"Watermarking\": false,\"WorldSearchable\": true,\"X2Larges\": true,\"X3Larges\": true,\"XLarges\": true}]}";
		AlbumTemplatesResponse value = MAPPER.readValue(json, AlbumTemplatesResponse.class);
		List<AlbumTemplate> list = new ArrayList<AlbumTemplate>();
		list.add(new AlbumTemplate(2, "smugmug default", "", true, false, 2, true, 
				new Community(0), true, true, false, false, false, true, 
				false, false, 2, true, true, true, "","", true, new Printmark(0),
				0, false, true, true, true, false, "Position", true, new Template(0),
				0.2f, 1f, 1f, 0.05f, new Watermark(0, "SmugMug"), false, true, 
				true, true, true));
		AlbumTemplatesResponse expected = new AlbumTemplatesResponse("ok", "smugmug.albumtemplates.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCategoryResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.categories.create\",\"Category\": {\"id\": 1234}}";
		CategoryResponse value = MAPPER.readValue(json, CategoryResponse.class);
		CategoryResponse expected = new CategoryResponse("ok", "smugmug.categories.create", new Category(1234));
		assertEquals(value, expected);
	}
	
	@Test
	public void testCategoriesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.categories.get\",\"Categories\": [{\"id\": 0,\"Name\": \"Other\",\"NiceName\": \"Other\",\"Type\": \"SmugMug\"},{\"id\": 1,\"Name\": \"Animals\",\"NiceName\": \"Animals\",\"Type\": \"SmugMug\"},{\"id\": 2,\"Name\": \"Architecture\",\"NiceName\": \"Architecture\",\"Type\": \"SmugMug\"},{\"id\": 3,\"Name\": \"Art\",\"NiceName\": \"Art\",\"Type\": \"SmugMug\"},{\"id\": 4,\"Name\": \"Boats\",\"NiceName\": \"Boats\",\"Type\": \"SmugMug\"},{\"id\": 5,\"Name\": \"Business\",\"NiceName\": \"Business\",\"Type\": \"SmugMug\"}]}";
		CategoriesResponse value = MAPPER.readValue(json, CategoriesResponse.class);
		List<Category> list = new ArrayList<Category>();
		list.add(new Category(0, "Other", "Other", "SmugMug"));
		list.add(new Category(1, "Animals", "Animals", "SmugMug"));
		list.add(new Category(2, "Architecture", "Architecture", "SmugMug"));
		list.add(new Category(3, "Art", "Art", "SmugMug"));
		list.add(new Category(4, "Boats", "Boats", "SmugMug"));
		list.add(new Category(5, "Business", "Business", "SmugMug"));
		CategoriesResponse expected = new CategoriesResponse("ok", "smugmug.categories.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCommentResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.comments.add\",\"Comment\": {\"id\": 1234}}";
		CommentResponse value = MAPPER.readValue(json, CommentResponse.class);
		CommentResponse expected = new CommentResponse("ok", "smugmug.albums.comments.add", new Comment(1234));
		assertEquals(value, expected);
	}
	
	@Test
	public void testCommunitiesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.communities.get\",\"Communities\": [{\"id\": 712,\"Name\": \"Australia\"},{\"id\": 17,\"Name\": \"DigitalGrin\"}]}";
		CommunitiesResponse value = MAPPER.readValue(json, CommunitiesResponse.class);
		List<Community> list = new ArrayList<Community>();
		list.add(new Community(712, "Australia"));
		list.add(new Community(17, "DigitalGrin"));
		CommunitiesResponse expected = new CommunitiesResponse("ok", "smugmug.communities.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCouponResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.coupons.getInfo\",\"Coupon\": {\"id\": 1234}}";
		CouponResponse value = MAPPER.readValue(json, CouponResponse.class);
		CouponResponse expected = new CouponResponse("ok", "smugmug.coupons.getInfo", new Coupon(1234));
		assertEquals(value, expected);
	}
	
	@Test
	public void testCouponsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.coupons.get\",\"Coupons\": [{\"id\": 1234},{\"id\": 5678}]}";
		CouponsResponse value = MAPPER.readValue(json, CouponsResponse.class);
		List<Coupon> list = new ArrayList<Coupon>();
		list.add(new Coupon(1234));
		list.add(new Coupon(5678));
		CouponsResponse expected = new CouponsResponse("ok", "smugmug.coupons.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testFamilyResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.family.get\",\"Family\": [{\"Name\": \"Joe Citizen\",\"NickName\": \"joe\",\"URL\": \"http://joe.smugmug.com\"}]}";
		FamilyResponse value = MAPPER.readValue(json, FamilyResponse.class);
		List<Family> list = new ArrayList<Family>();
		list.add(new Family("Joe Citizen", "joe", "http://joe.smugmug.com"));
		FamilyResponse expected = new FamilyResponse("ok", "smugmug.family.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testFansResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.fans.get\",\"Fans\": [{\"Name\": \"Joe Citizen\",\"NickName\": \"joe\",\"URL\": \"http://joe.smugmug.com\"}]}";
		FansResponse value = MAPPER.readValue(json, FansResponse.class);
		List<Fan> list = new ArrayList<Fan>();
		list.add(new Fan("Joe Citizen", "joe", "http://joe.smugmug.com"));
		FansResponse expected = new FansResponse("ok", "smugmug.fans.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testFeaturedResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.featured.albums.get\",\"Featured\": {\"Albums\": [{\"id\": 1234,\"Key\": \"xCXXu\"}]}}";
		FeaturedResponse value = MAPPER.readValue(json, FeaturedResponse.class);
		List<Album> list = new ArrayList<Album>();
		list.add(new Album(1234, "xCXXu"));
		Featured featured = new Featured(list);
		FeaturedResponse expected = new FeaturedResponse("ok", "smugmug.featured.albums.get", featured);
		assertEquals(value, expected);
	}
	
	@Test
	public void testFriendsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.friends.get\",\"Friends\": [{\"Name\": \"Joe Citizen\",\"NickName\": \"joe\",\"URL\": \"http://joe.smugmug.com\"}]}";
		FriendsResponse value = MAPPER.readValue(json, FriendsResponse.class);
		List<Friend> list = new ArrayList<Friend>();
		list.add(new Friend("Joe Citizen", "joe", "http://joe.smugmug.com"));
		FriendsResponse expected = new FriendsResponse("ok", "smugmug.friends.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testImageEXIFResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.images.getEXIF\",\"Image\": {\"id\": 12345,\"Key\": \"nrBE6\",\"Aperture\": \"f/2.8\",\"CCDWidth\": \"6mm\",\"ColorSpace\": \"1\",\"CompressedBitsPerPixel\": \"5/1\",\"DateTime\": \"2008-02-05 09:42:12\",\"DateTimeDigitized\": \"2008-02-05 09:42:12\",\"DateTimeOriginal\": \"2008-02-05 09:42:12\",\"DigitalZoomRatio\": \"3072/3072\",\"ExposureBias\": \"0/3\",\"ExposureMode\": 0,\"ExposureTime\": \"1/25\",\"Flash\": 16,\"FocalLength\": \"7700/1000\",\"Make\": \"Canon\",\"Model\": \"Canon DIGITAL IXUS 750\",\"SensingMethod\": 2,\"WhiteBalance\": 0}}";
		ImageEXIFResponse value = MAPPER.readValue(json, ImageEXIFResponse.class);
		ImageEXIFResponse expected = new ImageEXIFResponse("ok", "smugmug.images.getEXIF",new ImageEXIF(12345, "nrBE6", "f/2.8", "6mm", 1, "5/1", "2008-02-05 09:42:12", "2008-02-05 09:42:12", "2008-02-05 09:42:12","3072/3072", "0/3", 0, "1/25", 16, "7700/1000", "Canon", "Canon DIGITAL IXUS 750", 2, 0));
		assertEquals(value, expected);
	}
	
	@Test
	public void testImageResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.images.getInfo\",\"Image\": {\"id\": 12345,\"Key\": \"nrBE6\",\"Album\": {\"id\": 1234,\"Key\": \"xCXXu\",\"URL\": \"http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6\"},\"Caption\": \"\",\"Date\": \"2008-02-05 15:52:56\",\"FileName\": \"IMG_1234.JPG\",\"Format\": \"JPG\",\"Height\": 2304,\"Hidden\": false,\"Keywords\": \"\",\"LargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-L.jpg\",\"LastUpdated\": \"2008-02-05 22:16:52\",\"Latitude\": -37.819706,\"LightboxURL\": \"http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6-A-LB\",\"Longitude\": 145.202974,\"MD5Sum\": \"b1f26944e2fa6e20e88532e471239574\",\"MediumURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-M.jpg\",\"OriginalURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-O.jpg\",\"Position\": 1,\"Serial\": 0,\"Size\": 7457753,\"SmallURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-S.jpg\",\"ThumbURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-Th.jpg\",\"TinyURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-Ti.jpg\",\"Type\": \"Album\",\"Watermark\": false,\"Width\": 3072,\"X2LargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-X2L.jpg\",\"X3LargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-X3L.jpg\",\"XLargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-XL.jpg\"}}";
		ImageResponse value = MAPPER.readValue(json, ImageResponse.class);
		ImageResponse expected = new ImageResponse("ok", "smugmug.images.getInfo",new Image(12345,"nrBE6", new Album(1234, "xCXXu", "http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6"),
				"","2008-02-05 15:52:56","IMG_1234.JPG", "JPG", 2304, false, "", "http://fred.smugmug.com/photos/12345_nrBE6-L.jpg", 
				"2008-02-05 22:16:52", -37.819706f, "http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6-A-LB",
				145.202974f, "b1f26944e2fa6e20e88532e471239574", "http://fred.smugmug.com/photos/12345_nrBE6-M.jpg",
				"http://fred.smugmug.com/photos/12345_nrBE6-O.jpg",1, 0, 7457753, "http://fred.smugmug.com/photos/12345_nrBE6-S.jpg",
				"http://fred.smugmug.com/photos/12345_nrBE6-Th.jpg","http://fred.smugmug.com/photos/12345_nrBE6-Ti.jpg",
				"Album", false, 3072, "http://fred.smugmug.com/photos/12345_nrBE6-X2L.jpg", "http://fred.smugmug.com/photos/12345_nrBE6-X3L.jpg",
				"http://fred.smugmug.com/photos/12345_nrBE6-XL.jpg"));
		assertEquals(value, expected);
	}
	
	@Test
	public void testImageStatsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.images.getStats\",\"Image\": {\"id\": 1234,\"Key\": \"xCXXu\",\"Bytes\": 11583635,\"Hits\": 46,\"Large\": 10,\"Medium\": 15,\"Original\": 4,\"Small\": 10,\"X2Large\": 0,\"X3Large\": 3,\"XLarge\": 4}}";
		ImageStatsResponse value = MAPPER.readValue(json, ImageStatsResponse.class);
		ImageStatsResponse expected = new ImageStatsResponse("ok", "smugmug.images.getStats", new ImageStats(1234, "xCXXu", 11583635, 46, 10, 15, 4, 10, 0, 3, 4)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testPrintmarkResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPrintmarksResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSharegroupResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSharegroupsResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSubCategoriesResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSubCategoryResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testThemesResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUserResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUserStatsResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testWatermarkResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testWatermarksResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAlbumCommentsResponse() {
		//we have to test album twice, since SmugMug decided to use the
		//the attribute name 'Comments' twice. Once for the settings
		//to allow comments, and once when returning a list of
		//actual comments on an album
		fail("Not yet implemented");
	}
	
	

}
