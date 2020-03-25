/*
 * FormJson.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-25 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.io.Serializable;

/**
 * @author admin
 * @date   2020-03-25
 **/
public class FormJson implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * json数据
     */
    private String jsonData;

    private static final long serialVersionUID = 7644995837890139136L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取json数据
     *
     * @return json_data - json数据
     */
    public String getJsonData() {
        return jsonData;
    }

    /**
     * 设置json数据
     *
     * @param jsonData json数据
     */
    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jsonData=").append(jsonData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}