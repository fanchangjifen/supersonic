package com.tencent.supersonic.chat.corrector;

import com.tencent.supersonic.chat.api.pojo.SemanticCorrectInfo;
import com.tencent.supersonic.common.util.jsqlparser.SqlParserUpdateHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableCorrector extends BaseSemanticCorrector {

    public static final String TABLE_PREFIX = "t_";

    @Override
    public void correct(SemanticCorrectInfo semanticCorrectInfo) {
        super.correct(semanticCorrectInfo);
        Long modelId = semanticCorrectInfo.getParseInfo().getModelId();
        String sql = SqlParserUpdateHelper.replaceTable(semanticCorrectInfo.getSql(), TABLE_PREFIX + modelId);
        semanticCorrectInfo.setSql(sql);
    }

}
