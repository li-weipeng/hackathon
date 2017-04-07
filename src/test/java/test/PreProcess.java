package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by leoz on 2017/4/3.
 */
public class PreProcess {
    /**
     *取部分文件
     * */
    public void getSomeData() {
        try {
            StringBuffer sb = new StringBuffer("");

            FileReader reader = new FileReader("C:\\Users\\leoz\\Desktop\\hacker2017project\\info\\wiki_chinese_preprocessed.simplied.txt");
//            FileReader reader = new FileReader("C:\\Users\\leoz\\Desktop\\hacker2017project\\info\\wordvector.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            int index = 0;
            // write string to file
            FileWriter writer = new FileWriter("C:\\Users\\leoz\\Desktop\\hacker2017project\\info\\predata.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);


            while ((str = br.readLine()) != null) {
                index++;
                sb.append(str + "/n");
                System.out.println(str);
                if (index % 100 == 0) {
                    index = 0;

                    bw.write(sb.toString());
                }
            }

            br.close();
            reader.close();

            bw.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PreProcess preProcess = new PreProcess();
        preProcess.getSomeData();
    }
}
