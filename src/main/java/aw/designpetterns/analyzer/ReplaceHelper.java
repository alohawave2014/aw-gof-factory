package aw.designpetterns.analyzer;

/**
 * RSS feedを変換するヘルパークラス<br>
 * 拡張性を持たせるため、単純な変換ロジックですがクラス定義をしている
 */
public class ReplaceHelper {

    /**
     * 変換対象の文字列の一部文字列を、指定した文字列に全て変換して返す
     * @param src 変換対象となる文字列
     * @param src 変換前の文字列
     * @param dst 変換後の文字列
     * @return 変換後の文字列
     */
    public static String replaceAll(String text, String src, String dst){
        if ("".equals(src)){
            System.err.println("[Error]変換元文字列を指定してください。");
        }
        
        return text.replaceAll(src, dst);
    }
}
