package com.x.cms.core.entity.element;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.openjpa.persistence.jdbc.Index;

import com.x.base.core.entity.AbstractPersistenceProperties;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.entity.SliceJpaObject;
import com.x.base.core.entity.annotation.CheckPersist;
import com.x.base.core.entity.annotation.ContainerEntity;
import com.x.base.core.entity.annotation.EntityFieldDescribe;
import com.x.base.core.utils.DateTools;
import com.x.cms.core.entity.PersistenceProperties;

@Entity
@ContainerEntity
@Table(name = PersistenceProperties.Element.TemplateForm.table)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TemplateForm extends SliceJpaObject {

	private static final long serialVersionUID = -1032370866037915354L;

	private static final String TABLE = PersistenceProperties.Element.TemplateForm.table;

	@PrePersist
	public void prePersist() throws Exception {
		Date date = new Date();
		if (null == this.createTime) {
			this.createTime = date;
		}
		this.updateTime = date;
		if (null == this.sequence) {
			this.sequence = StringUtils.join(DateTools.compact(this.getCreateTime()), this.getId());
		}
		this.onPersist();
	}

	@PreUpdate
	public void preUpdate() throws Exception {
		this.updateTime = new Date();
		this.onPersist();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@EntityFieldDescribe("创建时间,自动生成.")
	@Index(name = TABLE + "_createTime")
	@Column(name = "xcreateTime")
	private Date createTime;

	@EntityFieldDescribe("修改时间,自动生成.")
	@Index(name = TABLE + "_updateTime")
	@Column(name = "xupdateTime")
	private Date updateTime;

	@EntityFieldDescribe("列表序号,由创建时间以及ID组成.在保存时自动生成.")
	@Column(length = AbstractPersistenceProperties.length_sequence, name = "xsequence")
	@Index(name = TABLE + "_sequence")
	private String sequence;

	@EntityFieldDescribe("数据库主键,自动生成.")
	@Id
	@Column(length = JpaObject.length_id, name = JpaObject.IDCOLUMN)
	@Index(name = TABLE + "_id")
	private String id = createId();

	/* 以上为 JpaObject 默认字段 */

	private void onPersist() throws Exception {
		if (StringUtils.isEmpty(this.category)) {
			this.category = "";
		}
	}

	/* 更新运行方法 */

	public static String[] FLAGS = new String[] { "id", "alias" };

	/* flag标志位 */
	/* Entity 默认字段结束 */

	public String getDataOrMobileData() {
		if (StringUtils.isNotEmpty(this.getData())) {
			return this.getData();
		} else if (StringUtils.isNotEmpty(this.getMobileData())) {
			return this.getMobileData();
		}
		return null;
	}

	public String getMobileDataOrData() {
		if (StringUtils.isNotEmpty(this.getMobileData())) {
			return this.getMobileData();
		} else if (StringUtils.isNotEmpty(this.getData())) {
			return this.getData();
		}
		return null;
	}

	@EntityFieldDescribe("名称.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xname")
	@CheckPersist(allowEmpty = true, simplyString = true)
	private String name;

	@EntityFieldDescribe("模版分类.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xcategory")
	@Index(name = TABLE + "_category")
	@CheckPersist(allowEmpty = false, simplyString = true)
	private String category;

	@EntityFieldDescribe("表单别名.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xalias")
	@CheckPersist(allowEmpty = true)
	private String alias;

	@EntityFieldDescribe("描述.")
	@Column(length = AbstractPersistenceProperties.processPlatform_name_length, name = "xdescription")
	@CheckPersist(allowEmpty = true)
	private String description;

	@EntityFieldDescribe("icon Base64编码后的文本.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_128K, name = "xicon")
	@CheckPersist(allowEmpty = true)
	private String icon;

	@EntityFieldDescribe("缩略图.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_1M, name = "xoutline")
	@CheckPersist(allowEmpty = true)
	private String outline;

	@EntityFieldDescribe("文本内容.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	// @Persistent(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_10M, name = "xdata")
	@CheckPersist(allowEmpty = true)
	private String data;

	@EntityFieldDescribe("移动端文本内容.")
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(length = JpaObject.length_10M, name = "xmobileData")
	@CheckPersist(allowEmpty = true)
	private String mobileData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMobileData() {
		return mobileData;
	}

	public void setMobileData(String mobileData) {
		this.mobileData = mobileData;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

}