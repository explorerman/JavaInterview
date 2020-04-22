package java_basic;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 李杰
 * @version 1.0
 * @Description 公文交换给消息队列推送
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/20 18:22
 * @title 标题: 公文交换给消息队列推送
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class DataexVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cecfwId;
    private String cecfwNum;
    private String cecfwTitle;
    private String cellphone;
    private String contact;
    private Date createTime;
    private String emergencyLevel;
    private Date lastModifyTime;
    private String lastModifyUser;
    private String limitReason;
    private Date limitTime;
    private String remark;
    private String secrecyLevel;
    private String signOpinion;
    private String signerName;
    private DataexFjVO dataexFjVO;

    public DataexFjVO getDataexFjVO() {
        return dataexFjVO;
    }

    public void setDataexFjVO(DataexFjVO dataexFjVO) {
        this.dataexFjVO = dataexFjVO;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCecfwId() {
        return cecfwId;
    }

    public void setCecfwId(String cecfwId) {
        this.cecfwId = cecfwId;
    }

    public String getCecfwNum() {
        return cecfwNum;
    }

    public void setCecfwNum(String cecfwNum) {
        this.cecfwNum = cecfwNum;
    }

    public String getCecfwTitle() {
        return cecfwTitle;
    }

    public void setCecfwTitle(String cecfwTitle) {
        this.cecfwTitle = cecfwTitle;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(String emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public String getLimitReason() {
        return limitReason;
    }

    public void setLimitReason(String limitReason) {
        this.limitReason = limitReason;
    }

    public Date getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Date limitTime) {
        this.limitTime = limitTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSecrecyLevel() {
        return secrecyLevel;
    }

    public void setSecrecyLevel(String secrecyLevel) {
        this.secrecyLevel = secrecyLevel;
    }

    public String getSignOpinion() {
        return signOpinion;
    }

    public void setSignOpinion(String signOpinion) {
        this.signOpinion = signOpinion;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }
}
