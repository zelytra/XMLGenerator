package XML;

import java.util.ArrayList;
import java.util.Arrays;

public class XML {
    private String line;
    private final String MRNumber;
    private final ArrayList<String> tags;

    public XML(String line, ArrayList<String> args) {
        ArrayList<String> content = new ArrayList<>(Arrays.asList(line.split(";")));
        this.tags = args;
        this.MRNumber = content.get(getIndexOfArgs("cleEmetteur"));
        this.line = "";
        this.line = this.line.concat("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <ns:interventionEmetteur xmlns:ns=\"com.grdf.poc.interventionEmetteur.v1.5\"> <ns:idIntervention>");
        this.line = this.line.concat(content.get(getIndexOfArgs("idIntervention")));
        this.line = this.line.concat("</ns:idIntervention> <ns:numSequenceIntervention>");
        this.line = this.line.concat(content.get(getIndexOfArgs("numSequenceIntervention")));
        this.line = this.line.concat("</ns:numSequenceIntervention> <ns:horodateIntervention>");
        this.line = this.line.concat(content.get(getIndexOfArgs("horodateIntervention")));
        this.line = this.line.concat("</ns:horodateIntervention> <ns:codeTypeIntervention>pose</ns:codeTypeIntervention> <ns:indexIntervention> <ns:indexMecaniqueSaisi>0</ns:indexMecaniqueSaisi> <ns:indexElectronique>0</ns:indexElectronique> <ns:indexMecaniqueReconstitue>0</ns:indexMecaniqueReconstitue> <ns:flagIncoherence>false</ns:flagIncoherence> <ns:nombreDeRoues>6</ns:nombreDeRoues> </ns:indexIntervention> <ns:situationFinale> <ns:compteur> <ns:cleCompteur>");
        this.line = this.line.concat(keyFormatter(content.get(getIndexOfArgs("cleCompteur"))));
        this.line = this.line.concat("</ns:cleCompteur> <ns:codePoidsImpulsion>");
        this.line = this.line.concat(content.get(getIndexOfArgs("codePoidsImpulsion")));
        this.line = this.line.concat("</ns:codePoidsImpulsion> </ns:compteur> <ns:emetteur> <ns:cleEmetteur>");
        this.line = this.line.concat(content.get(getIndexOfArgs("cleEmetteur")));
        this.line = this.line.concat("</ns:cleEmetteur> <ns:codeTypeEmetteur>deporte</ns:codeTypeEmetteur> <ns:versionReferentiel>");
        this.line = this.line.concat(content.get(getIndexOfArgs("versionReferentiel")));
        this.line = this.line.concat("</ns:versionReferentiel> <ns:compteurImpulsion> <ns:valeurImpulsion>");
        this.line = this.line.concat(content.get(getIndexOfArgs("valeurImpulsion")));
        this.line = this.line.concat("</ns:valeurImpulsion> <ns:horodateImpulsion>");
        this.line = this.line.concat(dateFormatter(content.get(getIndexOfArgs("horodateImpulsion"))));
        this.line = this.line.concat("</ns:horodateImpulsion> </ns:compteurImpulsion> <ns:confEmetteur> <ns:cleConfEmetteur>BACKUP_LOG</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>BACKUP_METERING</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>BACKUP_TECHNICAL</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>BITMAP</ns:cleConfEmetteur> <ns:valeurConfEmetteur>/g==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CFGFRAME_PERIOD</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CFGFRAME_SEND</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CIPH_CURRENT_KEY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CIPH_KEY_COUNT</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Dg==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CLOCK_CURRENT_EPOC</ns:cleConfEmetteur> <ns:valeurConfEmetteur>DkbpGg==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CLOCK_DRIFT_CORRECTION</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAE=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CURRENT_STATE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Aw==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>DATEHOUR_LAST_UPDATE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>DAYLIGHT_SAV</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>DUREE_REPONSE_INTERFACE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Mg==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>INDEX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAADQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART6</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART7</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART1</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART2</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART3</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART4</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EPOCH_REFERENTIEL</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Dkbo0A==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_LATEST</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5G6NIfAAA=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_PART1</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5G5igDAQAORucqAQpSDkbnKgEKIw5G5zUGBrMORuc7AgsC</ns:valeurConfEmetteur> </ns:confEmetteur> ");
        this.line = this.line.concat("<ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_PART2</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5G6NABCjUORujSHwAADkbo1QIBAA5G6NUCCwIORukFAQpS</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_PART3</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5G6QUBCiMORukRBQa1DkXrRgMBAA5F62sBClIORetrAQoj</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_PART4</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5F62wDCwIORet2BQbFDkXr8gEKNQ5F6/MBAAAORev0uQAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_PART5</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5F6/YHAQAORew1AQpSDkXsNgEKIw5F7D8GCwIORexBBQbC</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EVENT_LOG_PART6</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw5G5dQeAAAORuYGAQsCDkbmBwEBAA5G5iQBCjUORuYmRwAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EXCH_RESPONSE_DELAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>eA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EXCH_RESPONSE_DELAY_MIN</ns:cleConfEmetteur> <ns:valeurConfEmetteur>BQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EXCH_RX_DELAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>BQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>EXCH_RX_LENGTH</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>FLAG_DELAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Bw==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>FRAUDE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Ig==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>HEURE_GAZIERE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>HCA=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_PART5</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>INSTFRAME_DELAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>PA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>INTERFACE_RADIO</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>INTRADAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>L7RECEIVE_LENGTH_MAX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>ZA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>L7TRANSMIT_LENGTH_MAX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>ZA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>METER_MANUFACTURER</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Qw==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>METER_NUMBER</ns:cleConfEmetteur> <ns:valeurConfEmetteur>GUExg5Jn</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>MODULE_TYPE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>NB_FENETRE_CFG</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>NB_FENETRE_HOR</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>NB_FENETRE_INTRA</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Ag==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>NB_FENETRE_JOUR</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>NB_FENETRE_SUP</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PAS_MESURE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_LAST_EPOCH</ns:cleConfEmetteur> <ns:valeurConfEmetteur>DkbpBQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_NBFOUND</ns:cleConfEmetteur> <ns:valeurConfEmetteur>BQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY1</ns:cleConfEmetteur> <ns:valeurConfEmetteur>UheBESAxArDM</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY2</ns:cleConfEmetteur> <ns:valeurConfEmetteur>UReBFRFZArTF</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY3</ns:cleConfEmetteur> <ns:valeurConfEmetteur>UReBFRFZAbLB</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> ");
        this.line = this.line.concat("<ns:cleConfEmetteur>PING_REPLY4</ns:cleConfEmetteur> <ns:valeurConfEmetteur>UheBERQ5A6y2</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY5</ns:cleConfEmetteur> <ns:valeurConfEmetteur>UReBFRFZA661</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY6</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAAAAAAAAAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY7</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAAAAAAAAAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_REPLY8</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAAAAAAAAAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_RX_DELAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Cg==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_RX_DELAY_MIN</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Ag==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_RX_LENGTH</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Aw==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>PING_RX_LENGTH_MAX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Cg==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>RADIO_MANUFACTURER</ns:cleConfEmetteur> <ns:valeurConfEmetteur>TLQ=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>RADIO_NUMBER</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAQxEDAD</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>RF_DOWNSTREAM_CHANNEL</ns:cleConfEmetteur> <ns:valeurConfEmetteur>eA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>RF_DOWNSTREAM_MOD</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>RF_UPSTREAM_CHANNEL</ns:cleConfEmetteur> <ns:valeurConfEmetteur>ZA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>RF_UPSTREAM_MOD</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_LATEST</ns:cleConfEmetteur> <ns:valeurConfEmetteur>CgAAAAAAAAAAAAAAAA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>SORTIE_CLIENT</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>SURVEILLANCE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>TFEN_INTRADAY</ns:cleConfEmetteur> <ns:valeurConfEmetteur>tGCQwAA=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>TFEN_TELERELEVE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>UA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>TRACE_MODE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>TX_DELAY_FULLPOWER</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AGQ=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>TX_FREQ_OFFSET</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAA=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>TX_POWER</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AA==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>VECTEUR_ETAT</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AIU=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>VERS_FW_TRX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Alo=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>VERS_HW_TRX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQM=</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>VERSION_REFERENTIEL</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Ag==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>VIF</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>L7KMOB_INDEX</ns:cleConfEmetteur> <ns:valeurConfEmetteur>Mw==</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>CPT_RESET</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAAAgAAAAAAAAAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>ECART_INDEX_USINE</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AAAAAAAAAAAAAAAA</ns:valeurConfEmetteur> </ns:confEmetteur> <ns:confEmetteur> <ns:cleConfEmetteur>SEG_CLIENT</ns:cleConfEmetteur> <ns:valeurConfEmetteur>AQ==</ns:valeurConfEmetteur> </ns:confEmetteur> </ns:emetteur> </ns:situationFinale> </ns:interventionEmetteur>");

    }

    public String getLine() {
        return this.line;
    }

    public String getMRNumber() {
        return MRNumber;
    }

    private int getIndexOfArgs(String arg) {
        if (this.tags.contains(arg)) {
            return tags.indexOf(arg);
        }
        return 0;
    }

    private String dateFormatter(String input) {
        String[] splintedDate = input.split("/");
        int month = Integer.parseInt(splintedDate[1]);
        if (month < 10) {
            splintedDate[1] = "0" + month;
        }
        int day = Integer.parseInt(splintedDate[0]);
        if (day < 10) {
            splintedDate[0] = "0" + day;
        }
        return splintedDate[2] + "-" + splintedDate[1] + "-" + splintedDate[0] + "T09:30:00";
    }

    private String keyFormatter(String input) {
        int cle = input.length();
        if (cle != 14) {
            StringBuilder space = new StringBuilder();
            for (int x = 1; x <= 14 - cle; x++) {
                space.append(" ");
            }
            return space + input;
        }
        return input;
    }
}
