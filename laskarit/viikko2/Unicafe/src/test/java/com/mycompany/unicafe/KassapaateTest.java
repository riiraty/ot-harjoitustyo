package com.mycompany.unicafe;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }
    
    @Test
    public void uudessaKassassaRahaaTonni() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void uudessaKassassaMaukkaitaLounaitaMyytyNolla() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void uudessaKassassaEdullisiaLounaitaMyytyNolla() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void JosKateismaksuRiittavaKassasaldoKasvaaEdullisenLounaanVerran() {
        kassapaate.syoEdullisesti(500);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void JosKateismaksuRiittavaKassasaldoKasvaaMaukkaanLounaanVerran() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void JosKateismaksuRiittavaEdullistaOstaessaVaihtorahaOikein() {
        assertEquals(260, kassapaate.syoEdullisesti(500));
    }
    
    @Test
    public void JosKateismaksuRiittavaMaukastaOstaessaVaihtorahaOikein() {
        assertEquals(100, kassapaate.syoMaukkaasti(500));
    }
    
    @Test
    public void JosMaksuRiittavaNiinEdullisiaLounaitaMyytyKasvaa() {
        kassapaate.syoEdullisesti(500);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void JosMaksuRiittavaNiinMaukkaitaLounaitaMyytyKasvaa() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void JosMaksuEiRiitaEdulliseenKassasaldoEiMuutu() {
        kassapaate.syoEdullisesti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void JosMaksuEiRiitaMaukkaaseenKassasaldoEiMuutu() {
        kassapaate.syoMaukkaasti(200);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void JosMaksuEiRiitaEdulliseenVaihtorahanaMaksunVerran() { 
        assertEquals(200, kassapaate.syoEdullisesti(200));
    }
    
    @Test
    public void JosMaksuEiRiitaMaukkaaseenVaihtorahanaMaksunVerran() { 
        assertEquals(200, kassapaate.syoMaukkaasti(200));
    }
    
    @Test
    public void JosMaksuEiRiitaEdulliseenMyytyjenMaaraEiKasva() { 
        kassapaate.syoEdullisesti(200);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void JosMaksuEiRiitaMaukkaaseenMyytyjenMaaraEiKasva() { 
        kassapaate.syoMaukkaasti(200);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void JosKortillaTarpeeksiRahaaEdullisenHintaVeloitetaan() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    public void JosKortillaTarpeeksiRahaaMaukkaanHintaVeloitetaan() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void JosKortillaTarpeeksiRahaaEdulliseenPalautetaanTrue() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    public void JosKortillaTarpeeksiMaukkaaseenPalautetaanTrue() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void JosKortillaTarpeeksiRahaaMyytyjenEdullistenMaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void JosKortillaTarpeeksiRahaaMyytyjenMaukkaisenMaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void JosKortillaEiRahaaEdulliseenSaldoEiMuutu() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void JosKortillaEiRahaaMaukkaaseenSaldoEiMuutu() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void JosKortillaEiRahaaEdulliseenMyytyjenLounaidenMaaraEiMuutu() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void JosKortillaEiRahaaMaukkaaseenMyytyjenLounaidenMaaraEiMuutu() {
        Maksukortti kortti = new Maksukortti(200);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void JosKortillaEiTarpeeksiRahaaEdulliseenPalautetaanFalse() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    public void JosKortillaEiTarpeeksiRahaaMaukkaaseenPalautetaanFalse() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kassasaldoEiMuutuJosOstetaanEdullinenKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kassasaldoEiMuutuJosOstetaanMaukasKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void korttiaLadatessaKortinSaldoKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }
    
    @Test
    public void korttiaLadatessaKassanRahamaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaaSaldoSailyyEnnallaan() {
        Maksukortti kortti = new Maksukortti(1000);
        kassapaate.lataaRahaaKortille(kortti, -1000);
        assertEquals(1000, kortti.saldo());
    }
    
    
}
