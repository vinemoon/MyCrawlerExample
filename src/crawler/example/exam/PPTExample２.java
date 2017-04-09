package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.select.Elements;
import sun.text.normalizer.RangeValueIterator;



import static sun.plugin.javascript.navig.JSType.Element;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class PPTExample２ {
	// commit test
	// 123456
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑//
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1491703259.A.E2A.html";
		//String uri = "http://news.ltn.com.tw/news/life/paper/1092476";

		/*System.out.println(
				CrawlerPack.start()

				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼

				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri)
			    //.getFromXml(uri)

			    // 這兒開始是 Jsoup Document 物件操作

				.select("div#main-content.bbs-content.bbs-screen")
				.text()
		);	*/


		Elements jsoup = CrawlerPack.start()

				// 參數設定
				.addCookie("over18", "1")    // 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼

				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
				.getFromHtml(uri)
				//.getFromXml(uri)

				// 這兒開始是 Jsoup Document 物件操作

				.select("div#main-content.bbs-content.bbs-screen");
		jsoup.select("div,span").remove();
		System.out.println(jsoup.text());
	}
}
