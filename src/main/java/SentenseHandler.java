import java.util.List;
import java.util.Map;

import com.ansj.vec.preprocess.ReduceFile;
import com.google.common.collect.Lists;
import com.huaban.analysis.jieba.JiebaSegmenter;

/**
 * Created by liweipeng on 2017/4/7.
 */
public class SentenseHandler {
    public float[] getSentenceVerctor(String sentense, Map<String, float[]> wordVectorMap){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> currentLineWords = segmenter.sentenceProcess(sentense);
        List<String> currentLineUnStopsWords = Lists.newArrayList();
        for (String s : currentLineWords) {
            if (!ReduceFile.stop_words.contains(s)) {
                currentLineUnStopsWords.add(s);
            }
        }
        

    }
}
