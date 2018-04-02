package com.enlern.pen.sms.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by pen on 2018/3/5.
 * 保存数据实体
 */
@Entity
public class NodeSave {

    /**
     * id
     */
    @Id(autoincrement = true)
    private Long id;
    /**
     * 传感器类型
     */
    private String n_sensor_type;
    /**
     * 传感器编号
     */
    private String n_sensor_number;
    /**
     * 数据域
     */
    private String n_data_buffer;
    /**
     * 数据解析后的值
     */
    private String n_data;
    /**
     * 传感器名称
     */
    private String n_sensor_cn_name;

    /**
     * 完整协议
     */
    private String n_wsn;

    /**
     * 插入时间
     */
    private String n_insert_time;

    @Generated(hash = 938224562)
    public NodeSave(Long id, String n_sensor_type, String n_sensor_number,
            String n_data_buffer, String n_data, String n_sensor_cn_name,
            String n_wsn, String n_insert_time) {
        this.id = id;
        this.n_sensor_type = n_sensor_type;
        this.n_sensor_number = n_sensor_number;
        this.n_data_buffer = n_data_buffer;
        this.n_data = n_data;
        this.n_sensor_cn_name = n_sensor_cn_name;
        this.n_wsn = n_wsn;
        this.n_insert_time = n_insert_time;
    }

    @Generated(hash = 1888419363)
    public NodeSave() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getN_sensor_type() {
        return this.n_sensor_type;
    }

    public void setN_sensor_type(String n_sensor_type) {
        this.n_sensor_type = n_sensor_type;
    }

    public String getN_sensor_number() {
        return this.n_sensor_number;
    }

    public void setN_sensor_number(String n_sensor_number) {
        this.n_sensor_number = n_sensor_number;
    }

    public String getN_data_buffer() {
        return this.n_data_buffer;
    }

    public void setN_data_buffer(String n_data_buffer) {
        this.n_data_buffer = n_data_buffer;
    }

    public String getN_data() {
        return this.n_data;
    }

    public void setN_data(String n_data) {
        this.n_data = n_data;
    }

    public String getN_sensor_cn_name() {
        return this.n_sensor_cn_name;
    }

    public void setN_sensor_cn_name(String n_sensor_cn_name) {
        this.n_sensor_cn_name = n_sensor_cn_name;
    }

    public String getN_wsn() {
        return this.n_wsn;
    }

    public void setN_wsn(String n_wsn) {
        this.n_wsn = n_wsn;
    }

    public String getN_insert_time() {
        return this.n_insert_time;
    }

    public void setN_insert_time(String n_insert_time) {
        this.n_insert_time = n_insert_time;
    }
}
