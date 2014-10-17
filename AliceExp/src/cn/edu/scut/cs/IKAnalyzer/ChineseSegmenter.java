package cn.edu.scut.cs.IKAnalyzer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class ChineseSegmenter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("待分词语句:");
			String input = scanner.nextLine();
			if (input.toLowerCase().equals("bye")) {
				break;
			}
			System.out.println("分词的结果：" + IKAnalysis(input).replaceAll(" ", " /"));
		}
		scanner.close();
	}

	public static String IKAnalysis(String str) {

		if (str.getBytes().length == str.length()) {
			// 如果不包含中文，就直接返回。
			return str;
		} else {
			// 由于IK分词器，不支持特殊字符，所以将 * 改为中文字符“这是星号”,中文分词以后再将“这是星号”修正为为 *
			// 同理将 _ 改为中文字符串“这是下划线”，中文分词以后再将“这是下划线”修正为 _
			str = str.replaceAll("\\*", "这是星号").replaceAll("_", "这是下划线");
		}

		StringBuffer sb = new StringBuffer();
		try {
			byte[] bt = str.getBytes();
			InputStream ip = new ByteArrayInputStream(bt);
			Reader read = new InputStreamReader(ip);
			// 设置为智能分词
			IKSegmenter iks = new IKSegmenter(read, true);
			Lexeme t;
			while ((t = iks.next()) != null) {
				// 在每个分词元之后添加空格
				sb.append(t.getLexemeText() + " ");
			}
			// sb.delete(sb.length() - 1, sb.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		return sb.toString().replaceAll("这是星号", "*").replaceAll("这是下划线", "_");
	}
}
