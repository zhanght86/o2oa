/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.bbs.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.bbs.entity.BBSRoleInfo.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sat May 06 19:34:23 CST 2017")
public class BBSRoleInfo_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<BBSRoleInfo,Date> createTime;
    public static volatile SingularAttribute<BBSRoleInfo,String> creatorName;
    public static volatile SingularAttribute<BBSRoleInfo,String> description;
    public static volatile SingularAttribute<BBSRoleInfo,String> forumId;
    public static volatile SingularAttribute<BBSRoleInfo,String> forumName;
    public static volatile SingularAttribute<BBSRoleInfo,String> id;
    public static volatile SingularAttribute<BBSRoleInfo,String> mainSectionId;
    public static volatile SingularAttribute<BBSRoleInfo,String> mainSectionName;
    public static volatile SingularAttribute<BBSRoleInfo,Integer> orderNumber;
    public static volatile SingularAttribute<BBSRoleInfo,String> roleCode;
    public static volatile SingularAttribute<BBSRoleInfo,String> roleName;
    public static volatile SingularAttribute<BBSRoleInfo,String> roleType;
    public static volatile SingularAttribute<BBSRoleInfo,String> sectionId;
    public static volatile SingularAttribute<BBSRoleInfo,String> sectionName;
    public static volatile SingularAttribute<BBSRoleInfo,String> sequence;
    public static volatile SingularAttribute<BBSRoleInfo,Date> updateTime;
}
