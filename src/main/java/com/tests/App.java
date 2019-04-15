package com.tests;

import java.lang.reflect.TypeVariable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( String.format("Hello World! '%s'", "Blablabla") );
        
        App.Teste<TesteDto> testeService = new App.TesteImpl<TesteDto>();
        TesteDto testeDto = new TesteDto();
        
        TypeVariable<?> type = testeService.getClass().getTypeParameters()[0];
        
        System.out.println(type.getClass());
        System.out.println(testeDto.getClass());
        System.out.println(type.getGenericDeclaration().equals(testeDto.getClass()));
    }
    
    static interface Teste<T extends Dto> {}
    
    static interface Dto {}
    
    static class TesteDto implements Dto {}
    
    static class TesteImpl<T extends Dto> implements Teste<T> {}
}
