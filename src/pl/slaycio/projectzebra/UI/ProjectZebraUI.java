package pl.slaycio.projectzebra.UI;

import javax.servlet.annotation.WebServlet;

import pl.slaycio.projectzebra.datamodel.*;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("projectzebra")
public class ProjectZebraUI extends UI {

	
   
	
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ProjectZebraUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		
		
		
				try {
					ORMinit.initializeORM(Boolean.FALSE);
					System.out.println("Inicjalizacja ORM");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
				TabSheet tabsheet1 = new TabSheet();
				layout.addComponent(tabsheet1);

				// Create the first tab
				VerticalLayout tab1 = new VerticalLayout();
				tabsheet1.addTab(tab1, "Zak³adka numer 1");	
				
				TabSheet tabsheet2 = new TabSheet();
				layout.addComponent(tabsheet2);

				// Create the first tab
				VerticalLayout tab2 = new VerticalLayout();
				tabsheet2.addTab(tab2, "Zak³adka numer 2");	
				
				
				
				
		Button button2 = new Button("nowy wpis");
		button2.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
								
				layout.addComponent(new Label("Thank you for dodalem nowymrrbank"));
				
				
				//TODO trzeba bêdzie teraz wyprobowac zakladanie tych obiektow i wtedy GUI
				//FinancialInstitution nowaInstytucja = new FinancialInstitution("mBank", "", "", "mBank", "Bank", "mBank");
				//nowaInstytucja.saveUsingDAO();
				
				//Account account1 = new Account("eKonto4223", "Konto w mBanku", "Rachunek bie¿¹cy", "Pawel2", nowaInstytucja, "EKO");
				
				//System.out.println(account1.getFinInstitution());
				}
		});
		
		tabsheet1.addComponent(button2);
		//layout.addComponent(button2);
		
		
		
		
	}

	
	
}