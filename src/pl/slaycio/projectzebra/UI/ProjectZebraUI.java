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
			
		
		Button button2 = new Button("nowy wpis");
		button2.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
								
				layout.addComponent(new Label("Thank you for dodalem nowymrrbank"));
				
				
				
				FinancialEntity nowaInstytucja = new FinancialEntity("mBank", "", "", "mBank", "Bank", "mBank");
				//nowaInstytucja.saveUsingDAO();
				
				Account account1 = new Account("eKonto4223", "Konto w mBanku", "Rachunek bie¿¹cy", "Pawel2", nowaInstytucja, "EKO");
				//account1.saveUsingDAO();
				System.out.println(account1.getFinInstitution());
				}
		});
		layout.addComponent(button2);
		
		
		
		
	}

	
	
}