package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {

		String uri =
				"https://graph.facebook.com/v2.8"
						+ "/search?q=%E5%91%8A%E7%99%BD&type=page&limit=1000&fields=name,id,fan_count,talking_about_count"
						+ "&access_token=EAACEdEose0cBADAmVHdSRgFtZA5rXnnZCkZC6jTepXaxS5N7Di4YwMmEBs1qFIsWOX2SElFONdXIsBgRMRPeW41bDIlvyyiNTi3egrPTHWeadndFg3wnXpEuTrZBr8LdF8REDVf0saniVmZBH6pLwkmBelVewKJ09waqiDZAeqD4ZCfWOH8u41m";

		Elements elems =
				CrawlerPack.start()
						.getFromJson(uri)
						.select("data");

		String output = "id,名稱,按讚數,討論人數\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String name = data.select("name").text();
			String likes = data.select("fan_count").text();
			String talking_about_count = data.select("talking_about_count").text();

			output += id+",\""+name+"\","+likes+","+talking_about_count+"\n";
		}

		System.out.println( output );
	} 
}
