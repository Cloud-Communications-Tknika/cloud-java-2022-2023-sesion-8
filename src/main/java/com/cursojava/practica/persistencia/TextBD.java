package com.cursojava.practica.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.management.InvalidAttributeValueException;

import com.cursojava.practica.dominio.Persona;



public class TextBD implements IPersonaGBD{
    
    private Map<String, Persona> datos;


    public TextBD()
    {
        datos = new HashMap<String, Persona>();
    }

    public TextBD(File f) throws IOException, InvalidAttributeValueException
    {
        datos = new HashMap<String, Persona>();
        load(f);
    }

    @Override
    public Persona getPersona(String id) {

        Persona to_return = null;

        if(datos.containsKey(id))
        {
            to_return = datos.get(id);
        }
        return to_return;

    }

    @Override
    public boolean addPersona(Persona persona) {
        
        String id = persona.getId();

        if(!datos.containsKey(id))
        {
            datos.put(id, persona);
            return true;
        }

        return false;
        
    }

    public void load(File f) throws InvalidAttributeValueException, NumberFormatException, IOException
    {
        BufferedReader br = null;

        try {

            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);

            String readed;
            Persona persona;

            while((readed = br.readLine()) != null) 
            {
                String[] sep = readed.split(" ");
                
                if(sep.length == 3)
                {
                    persona = new Persona(sep[0], sep[1], Integer.parseInt(sep[2]));

                }
                else if(sep.length == 4)
                {
                    persona = new Persona(sep[0], sep[1], Integer.parseInt(sep[2]), Boolean.parseBoolean(sep[3]));
                }
                else
                {
                    throw new InvalidAttributeValueException("Valor no válido");
                }

                if(!datos.containsKey(sep[0]))
                {
                    datos.put(sep[0], persona);
                }
                
            }
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            if(br != null)
            {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }    
    }

    public void save() throws IOException
    {

        File file = new File("datos.txt");
        Persona persona;
        BufferedWriter bw = null;

        try {
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            Set<String> keys = datos.keySet();

            for (String key : keys) {
                
                persona = datos.get(key);

                String line = key + " " + persona.getName() + " " + persona.getAge() + " " + persona.isAlive();

                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(bw!=null)
            {
                bw.close();
            }
        }
    }

    @Override
    public boolean updatePersona(Persona persona) {
        
        String id = persona.getId();

        if(datos.containsKey(id))
        {
            datos.put(id, persona);
            return true;
        }

        return false;
 
   
    }

    @Override
    public boolean removePersona(String id) {
        // TODO Auto-generated method stub

        return true;
        
    }

}

