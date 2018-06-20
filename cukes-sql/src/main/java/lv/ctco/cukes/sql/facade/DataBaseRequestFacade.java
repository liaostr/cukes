package lv.ctco.cukes.sql.facade;

import com.google.inject.Inject;
import lv.ctco.cukes.sql.GenericTableRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lv.ctco.cukes.sql.utils.TableAssertUtils.assertContainsTableValues;
import static lv.ctco.cukes.sql.utils.TableAssertUtils.assertEqualsTableValues;
import static lv.ctco.cukes.sql.utils.TableAssertUtils.assertValueRelatesToValue;

public class DataBaseRequestFacade {

    @Inject
    private GenericTableRepository genericTableRepository;

    public void checkSchemeTableContains(String scheme, String tableName, List<Map<String, String>> tableValues) {
        List<Map<String, String>> values = genericTableRepository.getTableValues(scheme, tableName, extractColumns(tableValues));
        assertContainsTableValues(values, tableValues);
    }

    public void checkSchemeTableMatch(String scheme, String tableName, List<Map<String, String>> tableValues) {
        List<Map<String, String>> values = genericTableRepository.getTableValues(scheme, tableName, extractColumns(tableValues));
        assertEqualsTableValues(values, tableValues);
    }

    public void checkSchemeTableCount(String scheme, String tableName, String sign, Integer number) {
        Integer value = genericTableRepository.countTableValues(scheme, tableName);
        assertValueRelatesToValue(value, sign, number);
    }

    private List<String> extractColumns(List<Map<String, String>> tableValues) {
        if (tableValues.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList<>(tableValues.get(0).keySet()));
    }
}
