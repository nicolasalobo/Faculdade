public class Jogo {
private String titulo;
private String genero;
private int ano;


public Jogo(String titulo, String genero, int ano) {
this.titulo = titulo;
this.genero = genero;
this.ano = ano;
}


public String getTitulo() { return titulo; }
public String getGenero() { return genero; }
public int getAno() { return ano; }


public void setTitulo(String titulo) { this.titulo = titulo; }
public void setGenero(String genero) { this.genero = genero; }
public void setAno(int ano) { this.ano = ano; }


@Override
public String toString() {
return String.format("%s | %s | %d", titulo, genero, ano);
}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Jogo other = (Jogo) obj;
		if (titulo == null) return other.titulo == null;
		return titulo.equalsIgnoreCase(other.titulo);
	}

	@Override
	public int hashCode() {
		return (titulo == null) ? 0 : titulo.toLowerCase().hashCode();
	}
}