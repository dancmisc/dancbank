package views;

import org.junit.Test;
import play.mvc.Content;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class ViewsTest {
	
	@Test
	public void indexTemplate() {
		Content html = views.html.index.render("test");
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("TEST");
	}
}
