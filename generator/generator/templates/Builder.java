{%- macro args(i) -%}{% for i in range(i) %}{{i != 0 and ', ' or ''}}K k{{i + 1}}, V v{{i + 1}}{% endfor %}{%- endmacro -%}
{%- macro values(i) -%}{% for i in range(i) %}{{i != 0 and ', ' or ''}}k{{i + 1}}, v{{i + 1}}{% endfor %}{%- endmacro -%}
package com.collectionUtils;

import java.util.HashMap;
import java.util.Map;

public class Builder {
    {% for i in range(30) %}
    static public <K, V> Map<K, V> mapOf({{args(i + 1)}}) {
        return hashMapOf({{values(i + 1)}});
    }

    static public <K, V> Map<K, V> mapOf(Map<K, V> map, {{args(i + 1)}}) {
        {%- for i in range(i + 1) %}
        map.put(k{{i + 1}}, v{{i + 1}});
        {%- endfor %}
        return map;
    }

    static public <K, V> HashMap<K, V> hashMapOf({{args(i + 1)}}) {
        HashMap<K, V> map = new HashMap<>({{i + 1}});
        mapOf(map, {{values(i + 1)}});
        return map;
    }
    {% endfor %}
}