package com.x.portal.assemble.designer.jaxrs.script;

import com.x.base.core.exception.PromptException;

class DependedException extends PromptException {

	private static final long serialVersionUID = -9089355008820123519L;

	DependedException(String name, String id, String names) {
		super("脚本: {}, id:{}, 被其他脚本引用: {}.", name, id, names);
	}
}
