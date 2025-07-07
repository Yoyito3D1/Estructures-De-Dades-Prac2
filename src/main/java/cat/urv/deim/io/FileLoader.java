package cat.urv.deim.io;

import cat.urv.deim.models.ILlistaPelicules;
import cat.urv.deim.models.LlistaPelicules;
import cat.urv.deim.models.Pelicula;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
    public static void carregarFitxer(String path, ILlistaPelicules llista) {
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("###");
                if (parts.length != 3) { continue; }
                int idPelicula = Integer.parseInt(parts[0]);
                int dataSortida = Integer.parseInt(parts[1]);
                String nomPelicula = parts[2];
                Pelicula filmAux = new Pelicula(idPelicula, nomPelicula, dataSortida);
                llista.inserir(filmAux);
            }
            scanner.close();
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }
}
