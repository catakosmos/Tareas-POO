public enum Estado {
    Neutro("(-_-) Meh.... "),
    Feliz("\\(^_^)/ Weeeeeh!"), 
    Triste("(._.) snif.... "), 
    Hambriento("(0o0) hambre hambre!"), 
    Enojado("(ôwô) grrrr...."), 
    Cansado("(=_=) zzzz...."),
    Muerto("(x_x)");

    private final String StrEstado;


    Estado(String StrEstado){
        this.StrEstado=StrEstado;
    }

    public String getStrEstado(){
        return StrEstado;
    }
}
