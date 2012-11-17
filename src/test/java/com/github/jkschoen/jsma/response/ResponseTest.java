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
import com.github.jkschoen.jsma.model.Community;
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
		List<Album> albums = new ArrayList<Album>();
		albums.add(new Album(1234, "xCXXu", new Category(0, "Other"),"My Birthday 2008" ));
		AlbumsResponse expected = new AlbumsResponse("ok", "smugmug.albums.get", albums);
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
		List<AlbumTemplate> templates = new ArrayList<AlbumTemplate>();
		templates.add(new AlbumTemplate(2, "smugmug default", "", true, false, 2, true, 
				new Community(0), true, true, false, false, false, true, 
				false, false, 2, true, true, true, "","", true, new Printmark(0),
				0, false, true, true, true, false, "Position", true, new Template(0),
				0.2f, 1f, 1f, 0.05f, new Watermark(0, "SmugMug"), false, true, 
				true, true, true));
		AlbumTemplatesResponse expected = new AlbumTemplatesResponse("ok", "smugmug.albumtemplates.get", templates);
		assertEquals(value, expected);
	}
	
	@Test
	public void testCategoriesResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCategoryResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCommentResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCommunitiesResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCouponResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCouponsResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFamilyResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFansResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFeaturedResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFriendsResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testImageEXIFResponseResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testImageResponse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testImageStatsResponse() {
		fail("Not yet implemented");
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
