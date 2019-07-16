package vce.it.addrbook.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import vce.it.addrbook.core.Address;
import vce.it.addrbook.io.AddressBookFileManager;

public class AddressBookFrame extends Frame {

	private static final long serialVersionUID = -8636781869335336804L;
	
	private AddressBookFileManager	fileManager;
	private MenuBar 	mbAddressBook;
	private Menu    	mnuFile;
	private MenuItem	miNew;
	private MenuItem 	miOpen;
	private MenuItem 	miSave;
	private MenuItem 	miExit;

	private Panel	 	pnlNorth;
	private Panel    	pnlCenter;
	private Panel		pnlSearch;

	private Button		btnRemove;
	private Label		lblSearch;
	private TextField	tfSearch;
	private Button 		btnAdd;

	private Label		lblName;
	private TextField	tfName;
	private Label		lblAddrLine1;
	private TextField 	tfAddrLine1;
	private Label		lblAddrLine2;
	private TextField 	tfAddrLine2;
	private Label		lblCountry;
	private TextField	tfCountry;
	private Label		lblStateOrUnionTerritory;
	private TextField	tfStateOrUnionTerritory;
	private Label		lblDistrict;
	private TextField 	tfDistrict;
	private Label 		lblMandalOrTehsilOrTaluk;
	private TextField	tfMandalOrTehsilOrTaluk;
	private Label		lblCityOrTownOrVillage;
	private TextField 	tfCityOrTownOrVillage;
	private Label		lblMobile;
	private TextField	tfMobile;
	private Label		lblPin;
	private TextField	tfPin;

	private Label		lblStatus;

	private List		liNames;

	
	public AddressBookFrame(){

		initializeComponents();
		addComponentsToFrame();
		registerEventHandlers();	
		this.pack();
		this.setSize(600, 500);
		this.setVisible(true);
	}

	private boolean initializeComponents(){

		boolean initialized = false;	
		initializeMenuBar();
		initializeNorthPanel();
		initializeCenterPanel();	
		lblStatus = new Label("Status");
		liNames	  = new List();
		initialized = true;
		return initialized;

	}

	private boolean addComponentsToFrame(){

		boolean added = false;
		this.setMenuBar(mbAddressBook);
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(lblStatus, BorderLayout.SOUTH);
		this.add(liNames, BorderLayout.WEST);		
		added = true;
		return added;
	}

	private boolean registerEventHandlers(){

		boolean registered = false;
		this.addWindowListener(new WindowClosingListener());

		miNew.addActionListener(new NewMenuItemListener());
		miOpen.addActionListener(new OpenMenuItemListener());
		miSave.addActionListener(new SaveMenuItemListener());
		miExit.addActionListener(new ExitMenuItemListener());

		btnRemove.addActionListener(new RemoveButtonListener());
		tfSearch.addActionListener(new SearchFieldListener());
		btnAdd.addActionListener(new AddButtonListener());
		liNames.addItemListener(new ListSelectionListener());

		registered = true;
		return registered;

	}

	private void initializeMenuBar(){

		mbAddressBook	= new MenuBar();
		mnuFile			= new Menu("File");
		miNew			= new MenuItem("New");
		miOpen			= new MenuItem("Open");
		miSave			= new MenuItem("Save");
		miExit			= new MenuItem("Exit");

		mnuFile.add(miNew);
		mnuFile.add(miOpen);
		mnuFile.add(miSave);
		mnuFile.add(miExit);
		mbAddressBook.add(mnuFile);

	}

	private void initializeNorthPanel(){

		pnlNorth = new Panel(new GridLayout(1, 3));

		btnRemove = new Button("Remove");

		pnlSearch = new Panel();

		lblSearch = new Label("Search");
		tfSearch = new TextField(15);

		pnlSearch.add(lblSearch);
		pnlSearch.add(tfSearch);

		btnAdd = new Button("Add");

		
		pnlNorth.add(btnRemove);
		pnlNorth.add(pnlSearch);
		pnlNorth.add(btnAdd);

	}

	private void initializeCenterPanel(){

		pnlCenter = new Panel(new GridLayout(10,2));
		lblName		= new Label("Name");
		tfName		= new TextField("");
		lblCountry 	= new Label("Country");
		tfCountry	= new TextField("");
		lblStateOrUnionTerritory = new Label("State / Union Territory");
		tfStateOrUnionTerritory	 = new TextField("");
		lblDistrict	= new Label("District");
		tfDistrict	= new TextField("");
		lblMandalOrTehsilOrTaluk = new Label("Mandal / Tehsil / Taluk");
		tfMandalOrTehsilOrTaluk = new TextField("");
		lblCityOrTownOrVillage = new Label("City / Town / Village");
		tfCityOrTownOrVillage = new TextField("");
		lblAddrLine2 = new Label("Colony / Township");
		tfAddrLine2 = new TextField("");
		lblAddrLine1 = new Label("Plot No/ House No, Road No ");
		tfAddrLine1 = new TextField("");
		lblMobile = new Label("Mobile");
		tfMobile  = new TextField("");
		lblPin = new Label("PIN");
		tfPin = new TextField("");

		pnlCenter.add(lblName);
		pnlCenter.add(tfName);
		pnlCenter.add(lblAddrLine1);
		pnlCenter.add(tfAddrLine1);
		pnlCenter.add(lblAddrLine2);
		pnlCenter.add(tfAddrLine2);
		pnlCenter.add(lblCityOrTownOrVillage);
		pnlCenter.add(tfCityOrTownOrVillage);
		pnlCenter.add(lblMandalOrTehsilOrTaluk);
		pnlCenter.add(tfMandalOrTehsilOrTaluk);
		pnlCenter.add(lblDistrict);
		pnlCenter.add(tfDistrict);
		pnlCenter.add(lblStateOrUnionTerritory);
		pnlCenter.add(tfStateOrUnionTerritory);
		pnlCenter.add(lblCountry);
		pnlCenter.add(tfCountry);
		pnlCenter.add(lblPin);
		pnlCenter.add(tfPin);
		pnlCenter.add(lblMobile);
		pnlCenter.add(tfMobile);
		pnlCenter.setVisible(false);

	}

	private class WindowClosingListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}

	private class AddButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			String name = tfName.getText();
			String country = tfCountry.getText();
			String stateOrUnionTerritory =tfStateOrUnionTerritory.getText();
			String district = tfDistrict.getText();
			String mandalOrTehsilOrTaluk = tfMandalOrTehsilOrTaluk.getText();
			String cityOrTownOrVillage = tfCityOrTownOrVillage.getText();
			String addrLine1 = tfAddrLine1.getText();
			String addrLine2 = tfAddrLine2.getText();
			long mobileNumber;
			long pin;
			try {
				mobileNumber = Long.parseLong(tfMobile.getText());
				pin = Long.parseLong(tfPin.getText());
			} catch (NumberFormatException e1) {
				mobileNumber = 0L;
				pin = 0;
				
			}
			
			Address address = new Address(name,
										country,
										stateOrUnionTerritory,
										district,
										mandalOrTehsilOrTaluk,
										cityOrTownOrVillage,
										addrLine1,
										addrLine2,
										mobileNumber,
										pin);
			if(fileManager != null){
			
				int remaining = fileManager.getAddressBook().getAddrArrLength() - fileManager.getAddressBook().getAddressCount();
				if(remaining > 0){
					boolean status = fileManager.getAddressBook().addAddress(address);
					lblStatus.setText(address.getName() + " added to addressbook :" + status + " you can add " + remaining + " more." );
					clearNSetAddressFields();
				}else{
					lblStatus.setText("AddressBook is full..You can not add any addresses");
				}
				

			}else{
				lblStatus.setText("Open an existing address book or create a new one");
			}
			
				
		}
	}
	
	private void clearNSetAddressFields(){
		
		tfName.setText("");
		tfCountry.setText("");
		tfStateOrUnionTerritory.setText("");
		tfDistrict.setText("");
		tfMandalOrTehsilOrTaluk.setText("");
		tfCityOrTownOrVillage.setText("");
		tfAddrLine2.setText("");
		tfAddrLine1.setText("");
		tfMobile.setText("");
		tfPin.setText("");
	}
	
	private class RemoveButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){ 
			String name = liNames.getSelectedItem();
			if(fileManager != null) {
				boolean removed = fileManager.getAddressBook().removeAddress(name);
				liNames.remove(name);
				lblStatus.setText("address with name "+name+ "is removed" + removed);
			}else {
				lblStatus.setText("Create a new file or open existing file to remove an item ");
			}

		}
	}

	private class SearchFieldListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(fileManager != null){
				String searchString = tfSearch.getText();
				if(searchString!= null && searchString.equals("")){
					lblStatus.setText("Enter the string to be searched.");		
				}else{
					Address address = fileManager.getAddressBook().searchAddress(searchString);
					if(address!=null){
						lblStatus.setText("Address found");		
						liNames.add(searchString);
					}		
				}	
			}else{
				lblStatus.setText("Open or create a new address book for searching.");		
			}
		}
	}

	private class ListSelectionListener implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
			if(fileManager != null){
			
				lblStatus.setText(e.getSource().toString());
			}else{
				lblStatus.setText("search for an address before selecting list items");
			}
		}
			
	}

	private class OpenMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			FileDialog fileDialog = new FileDialog(AddressBookFrame.this);
			fileDialog.setVisible(true);
			String fileName = fileDialog.getFile();
			
			if(fileName != null) {
				File addressBookFile = new File(fileName);
								
				System.out.println("File Name : " + addressBookFile.getName());
				System.out.println("Absolute Path : " + addressBookFile.getAbsolutePath());
				
				fileManager = new AddressBookFileManager(addressBookFile);
				
				System.out.println("Address Book Capacity : " + fileManager.getAddressBook().getAddrArrLength());
				
				lblStatus.setText(addressBookFile.getAbsolutePath() + " opened");
				pnlCenter.setVisible(true);
				AddressBookFrame.this.setBounds(80, 80, 650, 510);
	
				
				System.out.println("Open Menu Success : " + addressBookFile.exists());
			}else {
				lblStatus.setText("No file opened");
			}
		}		
	}

	private class SaveMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(fileManager != null){
				fileManager.saveAdderssBook();
				lblStatus.setText(" AddressBook saved to  " + fileManager.getAddressBookFile().getAbsolutePath());
			}else{
				lblStatus.setText("open or create a new address book to save it");
			}
		}		
	}

	private class ExitMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}		
	}

	private class NewMenuMessageDialog extends Dialog{
	
		private static final long serialVersionUID = -1993341787701435614L;
		Panel pnlOption;
		Panel pnlFileName;
		
		Checkbox cbDefaultSize;
		Checkbox cbCustomSize;
		Checkbox cbDefaultFile;
		CheckboxGroup cbgOptions;
		
		TextField tfSize;
		Label	  lblSize;
		
		TextField tfFileName;
		Label	  lblFileName;
		
		Button 	  btnCreate;
		
		NewMenuMessageDialog(Frame aFrame){
			
			super(aFrame);
			this.setLayout(new GridLayout(3,1));
			this.setTitle("New Address Book");
			initializeComponents();
			addComponentsToDialog();
			registerEventHandlers();
			
			this.pack();
			this.setVisible(true);
	
		}
		
		void initializeComponents() {
		
			cbgOptions = new CheckboxGroup();
			cbDefaultSize = new Checkbox("Use Default Size", cbgOptions, true);
			cbCustomSize = new Checkbox("Custom Size", cbgOptions, false);
			
			pnlOption = new Panel(new GridLayout(1,4));
			
			lblSize = new Label("AddressBook Size :");
			tfSize =  new TextField("10");
			tfSize.setEditable(false);
			
			pnlOption.add(lblSize);
			pnlOption.add(cbDefaultSize);
			pnlOption.add(cbCustomSize);
			pnlOption.add(tfSize);
			
			
			pnlFileName = new Panel();
			pnlFileName.setLayout(new GridLayout(1, 3));

			lblFileName = new Label("File Name : ");
			tfFileName =  new TextField();
			tfFileName.setEditable(false);
			
			cbDefaultFile = new Checkbox("AddressBook.bin", true);
			
			pnlFileName.add(lblFileName);
			pnlFileName.add(cbDefaultFile);
			pnlFileName.add(tfFileName);
			
			btnCreate = new Button("Create");
			
		}
		
		void addComponentsToDialog() {
			this.add(pnlOption);
			this.add(pnlFileName);
			this.add(btnCreate);
		}
		
		void registerEventHandlers() {
		
			cbDefaultSize.addItemListener(new ItemListener() {
								
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						tfSize.setText("10");
						tfSize.setEditable(false);
					}
				}
			});
			
			cbCustomSize.addItemListener(new ItemListener() {
					
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						tfSize.setEditable(true);
						tfSize.setText("");
					}
				}
			});
	
			cbDefaultFile.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent e) {
			
					if(e.getStateChange() == ItemEvent.SELECTED) {
						tfFileName.setText(cbDefaultFile.getLabel());
						tfFileName.setEditable(false);
					}else {
						tfFileName.setText("");
						tfFileName.setEditable(true);
					}
				}
			});
			
			btnCreate.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					boolean cbDefaultSizeState = cbDefaultSize.getState();
					boolean cbDefaultFileState = cbDefaultFile.getState();
					
					String fileName = null;
					String addressBookSize = null;
					int    bookSize = 0;
					
					if(cbDefaultFileState){
						fileName = cbDefaultFile.getLabel();
					}else{
						fileName = tfFileName.getText();
						if(fileName.equals("") || fileName == null){
							fileName = "AddressBook.bin";
						}
					}
					
					if(cbDefaultSizeState){
						bookSize = Integer.parseInt(tfSize.getText());
					}else{
						addressBookSize = tfSize.getText();
						if(addressBookSize.equals("") || addressBookSize == null){
							bookSize = 10;
						}else{
							bookSize = Integer.parseInt(addressBookSize);
						}
						
					}
					
					System.out.println(fileName);
					System.out.println(bookSize);
						
					File addressBookFile = new File(fileName);
					
					fileManager = new AddressBookFileManager(addressBookFile, bookSize);
					
					System.out.println("After file creation");
					System.out.println("File Name : " + fileName);
					System.out.println("Length : " + fileManager.getAddressBook().getAddrArrLength());
					
					NewMenuMessageDialog.this.setVisible(false);
					pnlCenter.setVisible(true);
					lblStatus.setText(addressBookFile.getName() +
							" created at " +
							addressBookFile.getAbsolutePath() + 
							" with capacity " + fileManager.getAddressBook().getAddrArrLength());
					AddressBookFrame.this.setBounds(80, 80, 650, 510);
				}
			});
			this.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			});
			
		}
	}
	
	private class NewMenuItemListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			NewMenuMessageDialog newMenuMessageDialog = new NewMenuMessageDialog(AddressBookFrame.this);
			if(newMenuMessageDialog.isVisible()) {
				System.out.println("Dialog Box Visible");
			}else {
				System.out.println("not visible");
			}
		}		
	}

}
