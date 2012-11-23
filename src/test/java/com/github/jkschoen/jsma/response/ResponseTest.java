package com.github.jkschoen.jsma.response;

import static org.junit.Assert.assertEquals;

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
import com.github.jkschoen.jsma.model.AlbumComments;
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
import com.github.jkschoen.jsma.model.Sharegroup;
import com.github.jkschoen.jsma.model.SubCategory;
import com.github.jkschoen.jsma.model.Template;
import com.github.jkschoen.jsma.model.Theme;
import com.github.jkschoen.jsma.model.User;
import com.github.jkschoen.jsma.model.UserStats;
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
		Album album = new Album(1234l, "xCXXu", "", true, new Category(0l, "Other"),
				false, 0, true, "Photos from my party.", true, false,
				true, true, false, true, false, 20, true, "", 
				"My-Birthday-2008", false, "1973", 
				"What year was I born ?", 1, true, 1, false, false, 
				true, true,  false, "Position", true, new Template(0l), "My Birthday 2008",
				"Album", "http://fred.smugmug.com/Other/My-Birthday-2008/1234_xCXXu",
				0.2f, 1f, 1f, 0.05f, "", new Watermark(0l, "SmugMug"),
				false, true, true, true, true);
		AlbumResponse expected = new AlbumResponse("ok", "smugmug.albums.getInfo", album);
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.get\",\"Albums\": [{\"id\": 1234,\"Key\": \"xCXXu\",\"Category\":{\"id\": 0,\"Name\": \"Other\"},\"Title\": \"My Birthday 2008\"}]}";
		AlbumsResponse value = MAPPER.readValue(json, AlbumsResponse.class);
		List<Album> list = new ArrayList<Album>();
		list.add(new Album(1234l, "xCXXu", new Category(0l, "Other"),"My Birthday 2008" ));
		AlbumsResponse expected = new AlbumsResponse("ok", "smugmug.albums.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumStatsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.getStats\",\"Album\": {\"id\": 1234,\"Key\": \"xCXXu\",\"Bytes\": 11583635,\"Hits\": 46,\"Large\": 10,\"Medium\": 15,\"Original\": 4,\"Small\": 10,\"X2Large\": 0,\"X3Large\": 3,\"XLarge\": 4}}";
		AlbumStatsResponse value = MAPPER.readValue(json, AlbumStatsResponse.class);
		AlbumStatsResponse expected = new AlbumStatsResponse("ok", "smugmug.albums.getStats", new AlbumStats(1234l, "xCXXu", 11583635, 46, 10, 15, 4, 10, 0, 3, 4)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumTemplateResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albumtemplates.changeSettings\",\"AlbumTemplate\": {\"id\": 1234}}";
		AlbumTemplateResponse value = MAPPER.readValue(json, AlbumTemplateResponse.class);
		AlbumTemplateResponse expected = new AlbumTemplateResponse("ok", "smugmug.albumtemplates.changeSettings", new AlbumTemplate(1234l));
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumTemplatesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albumtemplates.get\",\"AlbumTemplates\": [{\"id\": 2,\"Name\": \"smugmug default\",\"Backprinting\": \"\",\"CanRank\": true,\"Clean\": false,\"ColorCorrection\": 2,\"Comments\": true,\"Community\": {\"id\": 0},\"EXIF\": true,\"External\": true,\"FamilyEdit\": false,\"Filenames\": false,\"FriendEdit\": false,\"Geography\": true,\"Header\": false,\"HideOwner\": false,\"InterceptShipping\": 2,\"Larges\": true,\"Originals\": true,\"PackagingBranding\": true,\"Password\": \"\",\"PasswordHint\": \"\",\"Printable\": true,\"Printmark\": {\"id\": 0},\"ProofDays\": 0,\"Protected\": false,\"Public\": true,\"Share\": true,\"SmugSearchable\": true,\"SortDirection\": false,\"SortMethod\": \"Position\",\"SquareThumbs\": true,\"Template\": {\"id\": 0},\"UnsharpAmount\": 0.2,\"UnsharpRadius\": 1,\"UnsharpSigma\": 1,\"UnsharpThreshold\": 0.05,\"Watermark\": {\"id\": 0,\"Name\": \"SmugMug\"},\"Watermarking\": false,\"WorldSearchable\": true,\"X2Larges\": true,\"X3Larges\": true,\"XLarges\": true}]}";
		AlbumTemplatesResponse value = MAPPER.readValue(json, AlbumTemplatesResponse.class);
		List<AlbumTemplate> list = new ArrayList<AlbumTemplate>();
		list.add(new AlbumTemplate(2l, "smugmug default", "", true, false, 2, true, 
				new Community(0l), true, true, false, false, false, true, 
				false, false, 2, true, true, true, "","", true, new Printmark(0l),
				0, false, true, true, true, false, "Position", true, new Template(0l),
				0.2f, 1f, 1f, 0.05f, new Watermark(0l, "SmugMug"), false, true, 
				true, true, true));
		AlbumTemplatesResponse expected = new AlbumTemplatesResponse("ok", "smugmug.albumtemplates.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCategoryResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.categories.create\",\"Category\": {\"id\": 1234}}";
		CategoryResponse value = MAPPER.readValue(json, CategoryResponse.class);
		CategoryResponse expected = new CategoryResponse("ok", "smugmug.categories.create", new Category(1234l));
		assertEquals(value, expected);
	}
	
	@Test
	public void testCategoriesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.categories.get\",\"Categories\": [{\"id\": 0,\"Name\": \"Other\",\"NiceName\": \"Other\",\"Type\": \"SmugMug\"},{\"id\": 1,\"Name\": \"Animals\",\"NiceName\": \"Animals\",\"Type\": \"SmugMug\"},{\"id\": 2,\"Name\": \"Architecture\",\"NiceName\": \"Architecture\",\"Type\": \"SmugMug\"},{\"id\": 3,\"Name\": \"Art\",\"NiceName\": \"Art\",\"Type\": \"SmugMug\"},{\"id\": 4,\"Name\": \"Boats\",\"NiceName\": \"Boats\",\"Type\": \"SmugMug\"},{\"id\": 5,\"Name\": \"Business\",\"NiceName\": \"Business\",\"Type\": \"SmugMug\"}]}";
		CategoriesResponse value = MAPPER.readValue(json, CategoriesResponse.class);
		List<Category> list = new ArrayList<Category>();
		list.add(new Category(0l, "Other", "Other", "SmugMug"));
		list.add(new Category(1l, "Animals", "Animals", "SmugMug"));
		list.add(new Category(2l, "Architecture", "Architecture", "SmugMug"));
		list.add(new Category(3l, "Art", "Art", "SmugMug"));
		list.add(new Category(4l, "Boats", "Boats", "SmugMug"));
		list.add(new Category(5l, "Business", "Business", "SmugMug"));
		CategoriesResponse expected = new CategoriesResponse("ok", "smugmug.categories.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCommentResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.comments.add\",\"Comment\": {\"id\": 1234}}";
		CommentResponse value = MAPPER.readValue(json, CommentResponse.class);
		CommentResponse expected = new CommentResponse("ok", "smugmug.albums.comments.add", new Comment(1234l));
		assertEquals(value, expected);
	}
	
	@Test
	public void testCommunitiesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.communities.get\",\"Communities\": [{\"id\": 712,\"Name\": \"Australia\"},{\"id\": 17,\"Name\": \"DigitalGrin\"}]}";
		CommunitiesResponse value = MAPPER.readValue(json, CommunitiesResponse.class);
		List<Community> list = new ArrayList<Community>();
		list.add(new Community(712l, "Australia"));
		list.add(new Community(17l, "DigitalGrin"));
		CommunitiesResponse expected = new CommunitiesResponse("ok", "smugmug.communities.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCouponResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.coupons.getInfo\",\"Coupon\": {\"id\": 1234}}";
		CouponResponse value = MAPPER.readValue(json, CouponResponse.class);
		CouponResponse expected = new CouponResponse("ok", "smugmug.coupons.getInfo", new Coupon(1234l));
		assertEquals(value, expected);
	}
	
	@Test
	public void testCouponsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.coupons.get\",\"Coupons\": [{\"id\": 1234},{\"id\": 5678}]}";
		CouponsResponse value = MAPPER.readValue(json, CouponsResponse.class);
		List<Coupon> list = new ArrayList<Coupon>();
		list.add(new Coupon(1234l));
		list.add(new Coupon(5678l));
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
		list.add(new Album(1234l, "xCXXu"));
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
		ImageEXIFResponse expected = new ImageEXIFResponse("ok", "smugmug.images.getEXIF",new ImageEXIF(12345l, "nrBE6", "f/2.8", "6mm", 1, "5/1", "2008-02-05 09:42:12", "2008-02-05 09:42:12", "2008-02-05 09:42:12","3072/3072", "0/3", 0, "1/25", 16, "7700/1000", "Canon", "Canon DIGITAL IXUS 750", 2, 0));
		assertEquals(value, expected);
	}
	
	@Test
	public void testImageResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.images.getInfo\",\"Image\": {\"id\": 12345,\"Key\": \"nrBE6\",\"Album\": {\"id\": 1234,\"Key\": \"xCXXu\",\"URL\": \"http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6\"},\"Caption\": \"\",\"Date\": \"2008-02-05 15:52:56\",\"FileName\": \"IMG_1234.JPG\",\"Format\": \"JPG\",\"Height\": 2304,\"Hidden\": false,\"Keywords\": \"\",\"LargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-L.jpg\",\"LastUpdated\": \"2008-02-05 22:16:52\",\"Latitude\": -37.819706,\"LightboxURL\": \"http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6-A-LB\",\"Longitude\": 145.202974,\"MD5Sum\": \"b1f26944e2fa6e20e88532e471239574\",\"MediumURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-M.jpg\",\"OriginalURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-O.jpg\",\"Position\": 1,\"Serial\": 0,\"Size\": 7457753,\"SmallURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-S.jpg\",\"ThumbURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-Th.jpg\",\"TinyURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-Ti.jpg\",\"Type\": \"Album\",\"Watermark\": false,\"Width\": 3072,\"X2LargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-X2L.jpg\",\"X3LargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-X3L.jpg\",\"XLargeURL\": \"http://fred.smugmug.com/photos/12345_nrBE6-XL.jpg\"}}";
		ImageResponse value = MAPPER.readValue(json, ImageResponse.class);
		ImageResponse expected = new ImageResponse("ok", "smugmug.images.getInfo",new Image(12345l,"nrBE6", new Album(1234l, "xCXXu", "http://fred.smugmug.com/gallery/1234_xCXXu#12345_nrBE6"),
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
		ImageStatsResponse expected = new ImageStatsResponse("ok", "smugmug.images.getStats", new ImageStats(1234l, "xCXXu", 11583635, 46, 10, 15, 4, 10, 0, 3, 4)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testPrintmarkResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.printmarks.getInfo\",\"Printmark\": {\"id\": 1234,\"Name\": \"My Custom Printmark\",\"Dissolve\": 50,\"Image\": {\"id\": 12345,\"Key\": \"nrBE6\"},\"Location\": \"BottomRight\"}}";
		PrintmarkResponse value = MAPPER.readValue(json, PrintmarkResponse.class);
		PrintmarkResponse expected = new PrintmarkResponse("ok", "smugmug.printmarks.getInfo", new Printmark(1234l, "My Custom Printmark", 50, new Image(12345l, "nrBE6"), "BottomRight")); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testPrintmarksResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.printmarks.get\",\"Printmarks\": [{\"id\": 1234,\"Name\": \"My Custom Printmark\"}]}";
		PrintmarksResponse value = MAPPER.readValue(json, PrintmarksResponse.class);
		List<Printmark> list = new ArrayList<Printmark>();
		list.add(new Printmark(1234l, "My Custom Printmark"));
		PrintmarksResponse expected = new PrintmarksResponse("ok", "smugmug.printmarks.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testSharegroupResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.sharegroups.getInfo\",\"ShareGroup\": {\"id\": 1234,\"Tag\": \"yZl6Z52YFiyc\",\"AlbumCount\": 1,\"Albums\": [{\"id\": 1234,\"Key\": \"xCXXu\",\"Title\": \"My Birthday 2008\"}],\"Description\": \"Private albums to share with family\",\"Name\": \"Family Photos\",\"Passworded\": false,\"URL\": \"http://fred.smugmug.com/share/yZl6Z52YFiyc\"}}";
		SharegroupResponse value = MAPPER.readValue(json, SharegroupResponse.class);
		List<Album> albums = new ArrayList<Album>();
		Album album = new Album(1234l, "xCXXu");
		album.setTitle("My Birthday 2008");
		albums.add(album);
		SharegroupResponse expected = new SharegroupResponse("ok", "smugmug.sharegroups.getInfo", 
				new Sharegroup(1234l, "yZl6Z52YFiyc", 1, albums, "Private albums to share with family",
						"Family Photos", false, "http://fred.smugmug.com/share/yZl6Z52YFiyc")); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testSharegroupsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.sharegroups.get\",\"ShareGroups\": [{\"id\": 1234,\"Tag\": \"yZl6Z52YFiyc\",\"AlbumCount\": 1,\"Description\": \"Private albums to share with family\",\"Name\": \"Family Photos\",\"Passworded\": false,\"URL\": \"http://fred.smugmug.com/share/yZl6Z52YFiyc\"}]}";
		SharegroupsResponse value = MAPPER.readValue(json, SharegroupsResponse.class);
		List<Sharegroup> list = new ArrayList<Sharegroup>();
		list.add(new Sharegroup(1234l, "yZl6Z52YFiyc", 1, "Private albums to share with family", "Family Photos", false, "http://fred.smugmug.com/share/yZl6Z52YFiyc"));
		SharegroupsResponse expected = new SharegroupsResponse("ok", "smugmug.sharegroups.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testSubCategoryResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.subcategories.create\",\"SubCategory\": {\"id\": 1234}}";
		SubCategoryResponse value = MAPPER.readValue(json, SubCategoryResponse.class);
		SubCategoryResponse expected = new SubCategoryResponse("ok", "smugmug.subcategories.create", new SubCategory(1234l)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testSubCategoriesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.subcategories.get\",\"SubCategories\": [{\"id\": 1234,\"Name\": \"Sunrise\",\"NiceName\": \"sunrise\"},{\"id\": 2345,\"Name\": \"Sunset\",\"NiceName\": \"sunset\"}]}";
		SubCategoriesResponse value = MAPPER.readValue(json, SubCategoriesResponse.class);
		List<SubCategory> list = new ArrayList<SubCategory>();
		list.add(new SubCategory(1234l, "Sunrise", "sunrise"));
		list.add(new SubCategory(2345l, "Sunset", "sunset"));
		SubCategoriesResponse expected = new SubCategoriesResponse("ok", "smugmug.subcategories.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testThemesResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.themes.get\",\"Themes\": [{\"id\": 24,\"Name\": \"SmugMug Classic\",\"Type\": \"smugmug\"},{\"id\": 59,\"Name\": \"SmugMug Dashed\",\"Type\": \"smugmug\"},{\"id\": 96,\"Name\": \"SmugMug Gradient\",\"Type\": \"smugmug\"}]}";
		ThemesResponse value = MAPPER.readValue(json, ThemesResponse.class);
		List<Theme> list = new ArrayList<Theme>();
		list.add(new Theme(24l, "SmugMug Classic", "smugmug"));
		list.add(new Theme(59l, "SmugMug Dashed", "smugmug"));
		list.add(new Theme(96l, "SmugMug Gradient", "smugmug"));
		ThemesResponse expected = new ThemesResponse("ok", "smugmug.themes.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testUserResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.users.getInfo\",\"User\": {\"Name\": \"Joe Citizen\",\"NickName\": \"joe\",\"URL\": \"http://joe.smugmug.com\"}}";
		UserResponse value = MAPPER.readValue(json, UserResponse.class);
		UserResponse expected = new UserResponse("ok", "smugmug.users.getInfo", new User("Joe Citizen","joe","http://joe.smugmug.com")); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testUserStatsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.users.getStats\",\"User\": {\"Bytes\": 11583635,\"Hits\": 46,\"Large\": 10,\"Medium\": 15,\"Original\": 4,\"Small\": 10,\"X2Large\": 0,\"X3Large\": 3,\"XLarge\": 4}}";
		UserStatsResponse value = MAPPER.readValue(json, UserStatsResponse.class);
		UserStatsResponse expected = new UserStatsResponse("ok", "smugmug.users.getStats", new UserStats(11583635, 46, 10, 15, 4, 10, 0, 3, 4)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testWatermarkResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.watermarks.getInfo\",\"Watermark\": {\"id\": 1234,\"Name\": \"My Custom Watermark\",\"Dissolve\": 50,\"Image\": {\"id\": 12345,\"Key\": \"nrBE6\"},\"Pinned\": \"Center\",\"Thumbs\": false}}";
		WatermarkResponse value = MAPPER.readValue(json, WatermarkResponse.class);
		WatermarkResponse expected = new WatermarkResponse("ok", "smugmug.watermarks.getInfo", new Watermark(1234l, "My Custom Watermark", 50, new Image(12345l, "nrBE6"), "Center", false)); 
		assertEquals(value, expected);
	}
	
	@Test
	public void testWatermarksResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.watermarks.get\",\"Watermarks\": [{\"id\": 1234,\"Name\": \"My Custom Watermark\"}]}";
		WatermarksResponse value = MAPPER.readValue(json, WatermarksResponse.class);
		List<Watermark> list = new ArrayList<Watermark>();
		list.add(new Watermark(1234l, "My Custom Watermark"));
		WatermarksResponse expected = new WatermarksResponse("ok", "smugmug.watermarks.get", list);
		assertEquals(value, expected);
	}
	
	@Test
	public void testAlbumCommentsResponse() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stat\": \"ok\",\"method\": \"smugmug.albums.comments.get\",\"Album\": {\"id\": 1234,\"Key\": \"xCXXu\",\"Comments\": [{\"id\": 1234,\"Date\": \"2007-09-11 00:46:21\",\"Rating\": 5,\"Text\": \"Great photos, looks like a fun party\",\"Type\": \"SmugMug\",\"User\": {\"Name\": \"Fred Nerk\",\"URL\": \"http://fred.smugmug.com\"}}]}}";
		AlbumCommentsResponse value = MAPPER.readValue(json, AlbumCommentsResponse.class);
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment(1234l, "2007-09-11 00:46:21", 5, "Great photos, looks like a fun party", "SmugMug", new User("Fred Nerk","http://fred.smugmug.com")));
		AlbumCommentsResponse expected = new AlbumCommentsResponse("ok", "smugmug.albums.comments.get", new AlbumComments(1234l, "xCXXu", comments)); 
		assertEquals(value, expected);
	}
}
