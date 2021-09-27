package fr.m2i.blog.combobox.admin;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import fr.m2i.blog.dto.AdminDto;
import fr.m2i.blog.service.AdminService;

public class AdminComboBox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AdminComboBoxModel comboBoxModel;

	JComboBox<AdminDto> comboBox;

	public AdminComboBox() {
		comboBoxModel = new AdminComboBoxModel();
		comboBox = new JComboBox<AdminDto>(comboBoxModel);
		comboBox.setRenderer(new AdminComboBoxRendered());

		this.add(comboBox);
	}

	public void updateComboBox() {
		comboBoxModel.removeAllElements();
		comboBoxModel.addAll(AdminService.findAll());
	}

	public void setSelectedItem(AdminDto admin) {
		this.comboBoxModel.setSelectedItem(admin);
	}

	public AdminDto getSelectedItem() {
		return comboBoxModel.getSelectedItem();
	}
}
