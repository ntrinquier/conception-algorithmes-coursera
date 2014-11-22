import java.util.LinkedList;

public class Dictionnaire {
    final Noeud racine;
    
    public Dictionnaire() {
    	racine = new Noeud('_');
    }

    public boolean existeMot(String s) {
        return racine.existeMot(s);
    }
    
    public boolean ajouteMot(String s) {
        Noeud noeud = racine;
        int pos = 0;
        boolean continueSearch = true;
        
        while (continueSearch) {
        	continueSearch = false;
        	
        	if (s.length() == pos) {     
                for (Noeud fils : noeud.fils)
                	if (fils.c == '*')
                		return false;
                break;
        	}
        	
	        for (Noeud fils : noeud.fils) {
	        	if (fils.c == s.charAt(pos)) {
	        		continueSearch = true;
	        		noeud = fils;
	        		pos++;
	        		break;
	        	}
	        }
        }
        
        for (int i = pos; i < s.length(); i++) {
        	Noeud n = new Noeud(s.charAt(i));
        	noeud.ajouteFils(n);
        	noeud = n;
        }

        noeud.ajouteFils(new Noeud('*'));
        
        return true;
    }
    
    public boolean estPrefixe(String s) {
        Noeud noeud = racine;
        boolean isPrefix = true;
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	isPrefix = false;
        	for (Noeud fils : noeud.fils) {
        		if (fils.c == c) {
        			isPrefix = true;
        			noeud = fils;
        			break;
        		}
        	}
    		
    		if (!isPrefix)
    			return false;
        }
        
        return true;
    }
    
    public void listeMotsAlphabetique() {
    	racine.listeMotsAlphabetique(new LinkedList<Character>());
    }
	
	public static String convertToString(LinkedList<Character> list) {
		StringBuilder sb = new StringBuilder();
		for (char c : list)
			sb.append(c);
		return sb.toString();
	}
}

class Noeud {
	public char c;
	public LinkedList<Noeud> fils;
	
    Noeud(char c) {
    	this.c = c;
    	this.fils = new LinkedList<Noeud>();
    }
    
    public void ajouteFils(Noeud a) {
    	int pos = 0;
    	for (Noeud fils: fils)
    		if (fils.c < a.c)
    			pos++;
    		else
    			break;
    	
    	fils.add(pos, a);
    }
    
    public boolean existeMotRecursif(String s, int pos) {
    	//System.out.println("pos: "+pos+"/"+s.length()+" - "+c);
    	if (s.length() == pos) {
        	for (Noeud noeud : fils) {
            	if (noeud.c == '*')
            		return true;
        	}
	    	return false;
    	}

    	for (Noeud noeud : fils) {
        	//System.out.println("char: "+noeud.c+"/"+s.charAt(pos));
        	if (noeud.c == s.charAt(pos))
        		return noeud.existeMotRecursif(s, pos+1);
    	}
    	return false;
    }
    
    public boolean estMot() {
    	return this.trouveFils('*') != null;
    }
	
	public boolean existeMot(String s) {
		return existeMotRecursif(s, 0);
	}
	
	public Noeud trouveFils(char c) {
		for (Noeud n : fils) {
			if (n.c == c) {
				return n;
			}
		}
		
		return null;
	}
	
	public void listeMotsAlphabetique(LinkedList<Character> prefix) {
		if (c == '*') {
			String mot = Dictionnaire.convertToString(prefix);
			System.out.print(mot.substring(0, mot.length()-1)+" ");
		} else {
			for (Noeud n : fils) {
				prefix.addLast(n.c);
				n.listeMotsAlphabetique(prefix);
				prefix.removeLast();
			}
		}
	}
}