package org.elasticsearch.index.analysis.lowercase;

import java.io.Reader;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractCharFilterFactory;

public class LowercaseCharFilterFactory extends AbstractCharFilterFactory {

    public LowercaseCharFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings seetings) {
        super(name);
    }

    @Override
    public Reader create(Reader reader) {
        return null;
    }
}
