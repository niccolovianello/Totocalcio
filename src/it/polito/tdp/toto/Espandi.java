package it.polito.tdp.toto;

public class Espandi {
	
	public void espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN());
		espandi(p, parziale, 0);
	}
	
	// Livello della ricorsione = singola partita
	// Livello = 0 --> la schedina ha zero risultati
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		// Se parziale contiene già (livello - 1) valori nelle posizioni 0...livello-1
		// io devo determinare parziale [livello], cioè la livello+1 esima riga sulla base della previsione in p[livello]
		
		if(livello == p.getN()) {
			System.out.println(parziale);
			return;
		}
		
		Previsione prev = p.get(livello);
		
		// prova le varie alternative
		for(Risultato r : prev.getValori()) {
			// Provo ad aggiungere 'r' alla soluzione
			parziale.add(r);
			
			espandi(p, parziale, livello+1);
			
			// backtrack --> devo portare tutto allo stato iniziale
			parziale.removeLast();
		}
	}

}
