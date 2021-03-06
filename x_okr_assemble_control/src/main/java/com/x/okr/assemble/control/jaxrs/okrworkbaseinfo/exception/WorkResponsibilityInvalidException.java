package com.x.okr.assemble.control.jaxrs.okrworkbaseinfo.exception;

import com.x.base.core.exception.PromptException;

public class WorkResponsibilityInvalidException extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	public WorkResponsibilityInvalidException( Throwable e, String person ) {
		super("系统根据用户所选择的责任者身份为工作信息组织责任者信息时发生异常。Person:" + person, e );
	}
}
