package br.feevale.physis.builder.menu;

import java.io.InputStream;

import resources.Resources;
import br.feevale.physis.business.model.bean.Menu;
import br.feevale.physis.util.MetadataUtils;

public class XmlMenuBuilder implements MenuBuilder {

	@Override
	public Menu build() {
		InputStream in = Resources.getResource(Resources.APPLICATION_MENU);
		Menu menu = MetadataUtils.fromXmlToObject(in, Menu.class);
		
		return menu;
	}

}
