/**
* 
* @author: Amir Armion 
* 
* @version: V.01
* 
*/
public class AllTypeOfCodons 
{

    public String findGene(String dna)
    {
        String gene       = "";
        int    startCodon = dna.indexOf("ATG");

        if(startCodon == -1)
        {
            return gene;
        }

        int taaIndex  = findStopCodon(dna, startCodon, "TAA");
        int tgaIndex  = findStopCodon(dna, startCodon, "TGA");
        int tagIndex  = findStopCodon(dna, startCodon, "TAG");

        int min1      = Math.min(taaIndex, tgaIndex);
        int stopCodon = Math.min(tagIndex, min1);

        if(stopCodon != dna.length())
        {
            return dna.substring(startCodon, stopCodon + 3);
        }
        else
        {
            return gene;
        }
    }

    public int findStopCodon(String dna, int startCodon, String stopCodonPattern)
    {
        int stopCodon = dna.indexOf(stopCodonPattern, startCodon + 3);

        while(stopCodon != -1)
        {
            if((stopCodon - startCodon) % 3 == 0)
            {
                return stopCodon;
            }
            else
            {
                stopCodon = dna.indexOf(stopCodonPattern, stopCodon + 1);
            }
        }

        return dna.length();
    }
}
