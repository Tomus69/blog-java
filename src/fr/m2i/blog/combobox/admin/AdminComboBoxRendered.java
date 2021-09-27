package fr.m2i.blog.combobox.admin;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import fr.m2i.blog.dto.AdminDto;

class AdminComboBoxRendered extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		AdminDto admin = (AdminDto) value;
		String infoAdmin = "";
		if (admin != null) {
			infoAdmin = admin.getName();
		}

		Component component = super.getListCellRendererComponent(list, infoAdmin, index, isSelected, cellHasFocus);
		component.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return component;
	}
}
