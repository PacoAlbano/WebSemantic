import java.io.File;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

import javax.management.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.AutoIRIMapper;

/**
 * Processing OWL Ontologies using Java
 * @author Clemens von Schwerin
 * @author Jean Felipe Oehrwald
 */

public class OWL_Test {
	
	
	public static final IRI powergrid_iri = IRI.create
			("file:///Users/felipe-oehrwald/Documents/GitHub/WebSemantic/WebSemantic/power_grid.owl");
	public static final IRI example_iri = IRI.create
			("http://www.semanticweb.org/ontologies/ont.owl");
	OWLDataFactory df = OWLManager.getOWLDataFactory();
	
	
	
	public static OWLOntologyManager create() {
		OWLOntologyManager m = OWLManager.createOWLOntologyManager();
		m.addIRIMapper(new AutoIRIMapper(
				new File("materializedOntologies"), true));
		return m;
	}
	
	public static void main(String[] args) {
		
		OWLOntologyManager m = create();
		OWLOntology o;
		try {
			o = m.loadOntologyFromOntologyDocument(powergrid_iri);
		

			System.out.println(o.getAxiomCount());	
			System.out.println(o.getClassesInSignature());
			System.out.println(o.getObjectPropertiesInSignature());
			System.out.println(o.getDataPropertiesInSignature());
			
			
			for(OWLNamedIndividual e: o.getIndividualsInSignature()){
				System.out.println(e.getObjectPropertiesInSignature());
				System.out.println(e.getIRI());
				System.out.println(e.getSignature());
				System.out.println(e.getDataPropertiesInSignature());
				System.out.println(e.toStringID());
				
				/*
				 * Identically without[] Brackets: System.out.println(o.getIndividualsInSignature());
				 */
				System.out.println(e.asOWLNamedIndividual());
				
				
			}
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}


		
		
		
	
	}
	
	
	
	
}
