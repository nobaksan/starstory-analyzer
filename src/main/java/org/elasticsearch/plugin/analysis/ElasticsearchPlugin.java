package org.elasticsearch.plugin.analysis;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.analysis.CharFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.chosung.ChosungTokenFilterFactory;
import org.elasticsearch.index.analysis.eng2kor.Eng2KorConvertFilterFactory;
import org.elasticsearch.index.analysis.jamo.JamoCharFilterFactory;
import org.elasticsearch.index.analysis.jamo.JamoTokenFilterFactory;
import org.elasticsearch.index.analysis.kor2eng.Kor2EngConvertFilterFactory;
import org.elasticsearch.index.analysis.lowercase.LowercaseCharFilterFactory;
import org.elasticsearch.index.analysis.soundex.SoundexConvertFilterFactory;
import org.elasticsearch.index.analysis.spell.SpellFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

/**
 * 필터 리스트
 *
 */
public class ElasticsearchPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {        
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        
        // (1) 한글 자모 분석 필터
        extra.put("jamo_filter", JamoTokenFilterFactory::new);
        
        // (2) 한글 초성 분석 필터
        extra.put("chosung_filter", ChosungTokenFilterFactory::new);
        
        // (3) 영한 오타 변환 필터
        extra.put("eng2kor_filter", Eng2KorConvertFilterFactory::new);
        
        // (4) 한영 오타 변환 필터
        extra.put("kor2eng_filter", Kor2EngConvertFilterFactory::new);

        // (5) 한글 단어 교정
        extra.put("soundex_filter", SoundexConvertFilterFactory::new);

        return extra;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<CharFilterFactory>> getCharFilters() {
        Map<String, AnalysisModule.AnalysisProvider<CharFilterFactory>> extra = new HashMap<>();

        extra.put("jamo_char_filter", JamoCharFilterFactory::new);
        extra.put("lowercase_char_filter", LowercaseCharFilterFactory::new);
        return extra;
    }
}



