//chocola problem - greedy algorithm
//we are given a bar of chocolate made of mxn square pieces.
//
import java.util.*;
public class chocola {
    public static void main (String args[]){
        int n=4, m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2}; //integer type li hai taki sorting easy hojaye
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        int h_cut =0, v_cut=0;
        int h_pieces=1, v_pieces=1;
        int cost =0;
        while(h_cut<costHor.length && v_cut<costVer.length){
            if(costVer[v_cut]< costHor[h_cut]){
                cost += (costHor[h_cut]*v_pieces);
                h_cut++;
                h_pieces++;
            }else{
                cost+= (costVer[v_cut]*h_pieces);
                v_cut++;
                v_pieces++;
            }
        }
        while(h_cut<costHor.length){
            cost += (costHor[h_cut]*v_pieces);
                h_cut++;
                h_pieces++;
        }
        while(v_cut<costVer.length){
            cost+= (costVer[v_cut]*h_pieces);
            v_cut++;
            v_pieces++;
        }
        System.out.println("Minimum cost= "+ cost);
    
    }
    
}
