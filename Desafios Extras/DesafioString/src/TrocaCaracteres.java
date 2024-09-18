public class TrocaCaracteres implements OperacaoCaracteres {

    @Override
    public String trocarLetras(String texto) {
        return texto.replace('a', '4')
                .replace('A', '4')
                .replace('e', '3')
                .replace('E', '3')
                .replace('o', '0')
                .replace('O', '0');
    }

}
