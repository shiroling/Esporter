package DBlink;

import java.util.function.Predicate;

public class Filters {
	
	Predicate<Integer> estTournoiEnCours = id -> DBPredicats.estTournoiEnCours(id);
	Predicate<Integer> estTournoiFini = id -> DBPredicats.estTournoiFini(id);
	Predicate<Integer> estTournoiAVenir = id -> DBPredicats.estTournoiAVenir(id);
	Predicate<Integer> sontInscriptionsFinies = id -> DBPredicats.sontInscriptionsFinies(id);
}
