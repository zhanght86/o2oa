package com.x.processplatform.assemble.surface.jaxrs.work;

import java.util.List;

import com.x.base.core.application.jaxrs.EqualsTerms;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.http.ActionResult;
import com.x.base.core.http.EffectivePerson;
import com.x.processplatform.assemble.surface.Business;
import com.x.processplatform.assemble.surface.Control;
import com.x.processplatform.assemble.surface.wrapout.content.WrapOutWork;
import com.x.processplatform.core.entity.content.Work;
import com.x.processplatform.core.entity.element.Application;

class ActionListPrevWithApplication extends ActionBase {

	ActionResult<List<WrapOutWork>> execute(EffectivePerson effectivePerson, String id, Integer count,
			String applicationFlag) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			Business business = new Business(emc);
			Application application = business.application().pick(applicationFlag);
			if (null == application) {
				throw new ApplicationNotExistedException(applicationFlag);
			}
			EqualsTerms equals = new EqualsTerms();
			equals.put("creatorPerson", effectivePerson.getName());
			equals.put("application", application.getId());
			ActionResult<List<WrapOutWork>> result = this.standardListPrev(workOutCopier, id, count, "sequence", equals,
					null, null, null, null, null, null, true, DESC);
			if (null != result.getData()) {
				for (WrapOutWork wrap : result.getData()) {
					Work o = emc.find(wrap.getId(), Work.class);
					Control control = business.getControlOfWorkList(effectivePerson, o);
					wrap.setControl(control);
				}
			}
			return result;
		}
	}
}
