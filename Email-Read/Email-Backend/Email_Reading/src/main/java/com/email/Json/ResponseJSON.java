package com.email.Json;

import java.util.HashMap;
import java.util.Map;

public class ResponseJSON {
    private Map<String, Object> result = new HashMap<String, Object>();

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public void addResult(String key, Object value) {
        result.put(key, value);
    }
}
