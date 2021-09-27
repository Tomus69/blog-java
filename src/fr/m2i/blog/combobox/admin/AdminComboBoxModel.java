package fr.m2i.blog.combobox.admin;

import javax.swing.DefaultComboBoxModel;

import fr.m2i.blog.dto.AdminDto;

public class AdminComboBoxModel extends DefaultComboBoxModel<AdminDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminComboBoxModel() {
	}

	@Override
	public AdminDto getSelectedItem() {
		AdminDto selectedAdmin = (AdminDto) super.getSelectedItem();
		return selectedAdmin;
	}
}
