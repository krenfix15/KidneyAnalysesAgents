package kidneyAnalysesAgents.AgentsBehaviour;

import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import kidneyAnalysesAgents.AgentsGUI.AgentAnalysesManagerGUI;
import kidneyAnalysesAgents.Helpers.Analyses;
import kidneyAnalysesAgents.Helpers.FileAdministrator;

public class AgentAnalysesManager extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Analyses analyses;

	private FileAdministrator adminFisier = new FileAdministrator();

	private AgentAnalysesManagerGUI agentInterface;

	@Override
	protected void setup() {
		agentInterface = new AgentAnalysesManagerGUI(this);
		agentInterface.showInterface();

		System.out.println("The analyses manager agent " + getAID().getName() + " is ready.\n");

		// Register in DF
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());

		ServiceDescription sd = new ServiceDescription();
		sd.setType("manager");
		sd.setName("JADE-Manager");

		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}

		addBehaviour(new ServiciuSold());

		addBehaviour(new ServiciuTranzactie());
	}

	// Delete the agent
	@Override
	protected void takeDown() {
		// Unregister from DF
		try {
			DFService.deregister(this);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}
		// Close the interface
		agentInterface.dispose();

		doDelete();

		System.out.println("The agent " + getAID().getName() + " is closing.\n");
	}

	private class ServiciuSold extends CyclicBehaviour {
		private static final long serialVersionUID = 1L;

		@Override
		public void action() {
			MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);

			ACLMessage msg = myAgent.receive(mt);

			if (msg != null) {
				// CFP Message received. Process it
				String mesaj = msg.getContent();

				ACLMessage reply = msg.createReply();

				try {
					analyses = adminFisier.GetClient(mesaj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Integer soldVechiClient = 1; //Integer.valueOf(client.getSold());

				if (soldVechiClient != null) {
					reply.setPerformative(ACLMessage.PROPOSE);
					reply.setContent("Sold curent: " + soldVechiClient.toString());
				} else {
					reply.setPerformative(ACLMessage.REFUSE);
					reply.setContent("not-available");
				}

				myAgent.send(reply);
			} else {
				block();
			}
		}
	} 

	private class ServiciuTranzactie extends CyclicBehaviour {
		private static final long serialVersionUID = 1L;

		@Override
		public void action() {
			MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);

			ACLMessage msg = myAgent.receive(mt);

			if (msg != null) {
				// CFP Message received. Process it
				String mesaj = msg.getContent();

				ACLMessage reply = msg.createReply();

				String informatii[] = mesaj.split(" ");

				String cnp = informatii[0];

				Integer suma = Integer.parseInt(informatii[1]);

				String operatie = informatii[2];

				Integer soldNou;

				try {
					analyses = adminFisier.GetClient(cnp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Integer soldVechiClient = 1; //Integer.valueOf(client.getSold());

				if (soldVechiClient != null && operatie.equals("adaugare")) {
					soldNou = soldVechiClient + suma;
					//client.setSold(soldNou.toString());

					System.out.println("Ad�ugare " + suma + " LEI �n cont. Sold cont: " + soldNou + " LEI");

					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Sold actualizat: " + String.valueOf(soldNou) + "\n");
				} else if (soldVechiClient != null && operatie.equals("extragere") && (soldVechiClient > suma)) {
					soldNou = soldVechiClient - suma;
					//client.setSold(soldNou.toString());

					System.out.println("Extragere " + suma + " LEI din cont. Sold cont: " + soldNou + " LEI");

					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent("Sold actualizat: " + String.valueOf(soldNou) + "\n");
				} else {
					System.out.println("Operatia nu poate fi efectuat�.\n");
					// Clientul cu acel CNP nu exista
					reply.setPerformative(ACLMessage.REFUSE);
					reply.setContent("not-possible");
				}

				//if (client != null && !client.getCNP().equals("")) {
					//adminFisier.UpdateClient(client);
				//}

				myAgent.send(reply);
			} else {
				block();
			}
		}
	}

}