import java.util.List;
import java.util.Map;

import com.ansj.vec.Learn;
import com.ansj.vec.preprocess.ReduceFile;
import com.google.common.collect.Lists;
import com.huaban.analysis.jieba.JiebaSegmenter;

/**
 * Created by liweipeng on 2017/4/7.
 */
public class SentenseHandler {
    public float[] getSentenceVerctor(String sentense, Map<String, float[]> wordVectorMap){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> sentenseLineWords = segmenter.sentenceProcess(sentense);
        List<String> sentenseUnStopsWords = Lists.newArrayList();
        for (String s : sentenseLineWords) {
            if (!ReduceFile.stop_words.contains(s)) {
                sentenseUnStopsWords.add(s);
            }
        }
        float[] senVerctor = new float[Learn.layerSize];
        for(String word : sentenseUnStopsWords){
            if (wordVectorMap.containsKey(word)){
                float[] wordVector = wordVectorMap.get(word);
                for (int i = 0; i < Learn.layerSize; i++){
                    senVerctor[i] += wordVector[i];
                }
            }
        }
        return senVerctor;
    }
}
