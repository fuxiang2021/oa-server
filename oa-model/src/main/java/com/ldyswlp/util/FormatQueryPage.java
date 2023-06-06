package com.ldyswlp.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.List;

public class FormatQueryPage {

    // 优化返回结果
    public static <T> HashMap<String, Object> format(Page<T> pageModel) {
        // 创建集合
        HashMap<String, Object> data = new HashMap<>();

        // 获取查询的结果
        List<T> result = pageModel.getRecords();
        // 总条数
        long total = pageModel.getTotal();
        // 总页数
        long pages = pageModel.getPages();

        data.put("result", result);
        data.put("total", total);
        data.put("pages", pages);

        return data;
    }
}
