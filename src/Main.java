/*
******************************** COLLEGE KILLS *********************************
AUTOR: WELLERSON PRENHOLATO DE JESUS
UNIVERSIDADE FEDERAL DO ESPÍRITO SANTO
DISCIPLINA: SISTEMAS DE MULTIMÍDIA
2018/2
********************************************************************************
*/

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import processing.core.*;
import processing.sound.*;
import static processing.core.PApplet.second;
import static processing.core.PConstants.CODED;
import static processing.core.PConstants.DOWN;
import static processing.core.PConstants.LEFT;
import static processing.core.PConstants.RIGHT;
import static processing.core.PConstants.UP;	

public class Main extends PApplet{

    public static void main(String[] args) {
        PApplet.main("Main");
    }
    
    //**********************Declaração de Variaveis*****************************
    boolean verificaPrimeiraVez;
    boolean botao1= false, botao2=false, botao3=false;
    
    float rot = 0;
    float x=0, y=0;
    boolean subir, descer, direita, esquerda;
    boolean personagemPrincipal;
    boolean game=false;
    int nivel=1;
    int recordeTotal, recordeAtual;
    
    SoundFile somTiro, FreeFire, eliminaAlvo;
    
    Player p;//Player principal
    PImage imagemPersonagemPrincipal;
    
    PImage imagemAlunoPrincipal;
    // ************************** ALVOS INIMIGOS ******************************
    PImage imagemOnibus,documento1, documento2, imagemCalculo, carteiraVazia, python, aspectos; //NIVEL 1
    
    PImage cCompletoTotal;//NIVEL 2
    
    PImage imagemEletromag;//NIVEL 3
    
    PImage java;//NIVEL 4
    
    PImage imagemArquitetura; // NIVEL 5
    
    PImage ia, so; //NIVEL 6
    
    PImage bd, compiladores, sistemaMultimidia; //NIVEL 7
    
    PImage grafos; //NIVEL 8
    
    PImage tcc; //NIVEL 9
    
    PImage facebook, google; //NIVEL 10
    
    PImage backgroundGameOver;
    
    //*************************************************************************
    
    //********************************* FONTES *********************************
    PFont font32;
    PFont font48;
    //**************************************************************************
    
    //***************************** IMAGENS BOTOÕES ****************************
    PImage botaoIniciarVazio;
    PImage botaoSair;
    //*************************************************************************
    
    //************************* IMAGENS BACKGROUND ****************************
    PImage ceunes; 
    PImage fundoInicio;
    PImage fundoJogoExecucao;
    PImage imagemStart; 
    PImage brasaoUFES;
    PImage tutorialInicio;
    PImage fundoPlacar;
    //*************************************************************************
    
    //********************** IMAGENS REFERENTES AO INICIAR ********************
    PImage imagemMouse;
    PImage imagemCreditos;
    //*************************************************************************
    
    Jogo jogador = new Jogo();
    //Alvos alvo1, alvo2, alvo3;
  
    //********************* INICIALIZAÇÃO DO VETOR DE ALVOS *******************
    int numAlvos = 10;
    Alvos[] alvo = new Alvos[numAlvos]; //Vetor de alvos - 10 alvos
    //*************************************************************************
    
    ArrayList<Tiro> tiros;
    boolean atirar;
    boolean perdeu;
    float recarga;
    int i, velocidade, pontos;
    
    int recorde; //Não estou usando até o momento
    
    Drop d;// Fundo da janela (Chuva)
    Drop[] drops = new Drop[180];// Fundo da janela (Chuva)
    
    PImage[] inimigos = new PImage[2]; //Vetor de objetos inimigos
    
    //**************************************************************************
    int telaCompleta =1000, telaCompleta2 = 600;
    int metadeTela1 = 500, metadeTela2 = 300;
    
//***************************** IMPORTANTE *************************************    
    @Override
    public void settings (){ //INICIA JANELA
        size (telaCompleta,telaCompleta2);  
    }
//*****************************************************************************    
    	    
    @Override
    public void setup(){ //Executa apenas uma vez
        //********************  SONS DO JOGO ***********************
        somTiro = new SoundFile(this,"Colt 45.mp3");
        //somTiro = new SoundFile(this,"tmp-1.mp3");
        //eliminaAlvo = new SoundFile(this, "footstep5_tank.mp3");
        FreeFire = new SoundFile(this, "Free Fire.mp3");
        FreeFire.play();
        //************************************************************
        
        p = new Player(); //Instância o objeto
        //p.desenhaPersonagem(); //Cria o personagem
        
        //********************  IMAGENS INIMIGOS - ALVOS ***********************
        imagemOnibus = loadImage("vetores\\onibus.png");
        //documento1 = loadImage("vetores\\documento1.png");
        //documento2 = loadImage("vetores\\documento2.png");
        imagemArquitetura = loadImage("vetores\\arquitetura.png");
        imagemCalculo = loadImage("vetores\\calculo.png");
        carteiraVazia = loadImage("vetores\\carteiraVazia.png");
        python = loadImage("vetores\\Python.png");
        aspectos = loadImage("vetores\\Aspectos.png");
        
        cCompletoTotal = loadImage("vetores\\cCompletoTotal.png");
        
        imagemEletromag = loadImage("vetores\\Eletromag.png");
        
        java = loadImage("vetores\\Java.png");
        
        ia = loadImage("vetores\\ia.png");
        so = loadImage("vetores\\so.png");
        
        bd = loadImage("vetores\\bd.png");
        compiladores = loadImage("vetores\\compiladores.png");
        sistemaMultimidia = loadImage("vetores\\multimidia.png");
        
        grafos = loadImage("vetores\\Grafos.jpg");
        
        tcc = loadImage("vetores\\tcc.png");
        
        facebook = loadImage("vetores\\Facebook.png");
        google = loadImage("vetores\\Google.png");
        //*********************************************************************
  
        //************************* BackGround's *******************************
        fundoInicio = loadImage("vetores\\background_Inicio.jpg");
        fundoJogoExecucao = loadImage("vetores\\imagemFundoGame2.jpg");
        backgroundGameOver = loadImage("vetores\\game_over_semplacar.jpg");
        fundoPlacar = loadImage("vetores\\fundo_placar.png");
        //**********************************************************************
        
        //******************** IMAGENS REFERENTES AO INICIAR *******************
        imagemStart = loadImage("vetores\\start.png"); //Não está sendo usada
        brasaoUFES = loadImage("vetores\\brasao_ufes.png"); //Não está sendo usada       
        botaoSair = loadImage("vetores\\botaoPrataVazio.png"); //Não está sendo usada
        tutorialInicio = loadImage("vetores\\tutorial.png");
        botaoIniciarVazio = loadImage("vetores\\botaoPrataVazio.png");
        imagemCreditos = loadImage("vetores\\backgroundCreditos.png");
        //**********************************************************************
        
        // *********************** INICIA FONTES *******************************
        font32 =loadFont("bad_signal\\BadSignal-32.vlw");
        font48 = loadFont("bad_signal\\BadSignal-48.vlw");
        //**********************************************************************       
        
        //imagemPersonagemPrincipal.resize(100,100);
        
       /* for (int i=0; i<drops.length; i++){
            drops[i] = new Drop();
        }*/
       
        tiros = new ArrayList<>();
        jogador = new Jogo();
        
        //INICIALIZAÇÃO DOS ALVOS
        for (int b=0; b<alvo.length; ++b){
            alvo[b] = new Alvos((int)(random(30, width - 50)), 0, 30, 1, false);
        }
        
        atirar=true;
        perdeu=false;
        velocidade=1;
        pontos=0;
        recordeAtual =0; //REINICIALIZA O RECORDE A CADA JOGADA
    }
    
    //********************  EXECUTA VÁRIAS VEZES -> LOOP ***********************
    @Override
    public void draw (){ //Executa várias vezes -> Loop
        
        verificaPrimeiraVez = false;
        
        if (verificaPrimeiraVez == false){
            telaInicial();
            miraMouse();
        }
        
        if (botao1 == true && verificaPrimeiraVez == false){
            verificaPrimeiraVez = true;
        }
        if (botao2 == true && verificaPrimeiraVez==false){
            acaoBotao2Creditos();
        }
        if (botao3 == true && verificaPrimeiraVez == false){
            ConfirmarSaida();   
        }
        if (verificaPrimeiraVez){
            jogoRodando();
            miraMouse(); //Desenha a mira em cima do jogo
        }
        escreveVersao();
    }
    //**************************************************************************
    
    void jogoRodando(){
            //***************** BACKGROUND DO JOGO EM EXECUÇÃO *****************
            fundoJogoExecucao.resize(1000, 600); //Redimensiona a imagem           
            background(fundoJogoExecucao); //Define a imagem como background
            //******************************************************************
            
        if (perdeu==false){ //verifica a variavel indicadora de comeco de jogo
             definePeriodo(pontos);
             //Inicializa os alvos - FUNCIONANDO
             if (nivel == 1){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(3);
             alvo[3].desenhaAlvo(6);
             alvo[4].desenhaAlvo(5);
             }
             if (nivel == 2){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(7);
             }
             if (nivel == 3){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(8);
             }
             if (nivel == 4){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(9);
             
             }
             if (nivel ==5 ){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(4);
             }
             if (nivel == 6){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(10);
             alvo[4].desenhaAlvo(11);
             }
             if (nivel == 7){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5); 
             alvo[3].desenhaAlvo(12);
             alvo[4].desenhaAlvo(13);
             alvo[5].desenhaAlvo(18);
             }
             if (nivel == 8){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(14);
             }
             if (nivel == 9){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(15);
             }
             if (nivel >= 10){
             alvo[0].desenhaAlvo(1);
             alvo[1].desenhaAlvo(2);
             alvo[2].desenhaAlvo(5);
             alvo[3].desenhaAlvo(16);
             alvo[4].desenhaAlvo(19);
             }
             
             for (int k=0; k<alvo.length; ++k){
                 if (alvo[k].checar == true) //se o alvo foi destruido, cria outro em um lugar aleatorio
                    alvo[k] = new Alvos((int)(random(30, width - 50)), 0, 30, velocidade, false);
             }

             jogador.atualiza();
             if (mousePressed == true){
                 somTiro.play();
                 somTiro.pause();
             }
             for (i = tiros.size ()-1; i >= 0; i--){
                 Tiro tiro = tiros.get(i);    
                 //somTiro.play();
                 //somTiro.pause();
                 tiro.atualiza();
             }
             //rect(width/2, height-20, 30, 40, 10); //desenho do tank

             pushMatrix(); 
             translate((width/2), height-20); //Localização da RETA

             float a = atan2(mouseY+20-height, mouseX-width/2);

             rotate(a); //Rotação da reta
             //line(0, 0, 30, 1);
             popMatrix();

             //ellipse(width/2, height-20, 30, 30);
             image(imagemAlunoPrincipal, (width/2)-40, height-110);
             imagemAlunoPrincipal.resize(100, 100);
             
             //PLACAR VERDE DO JOGO EM EXECUÇÃO
             image(fundoPlacar,10,(height/2)-310);
             fundoPlacar.resize(270, 120);
             
             textAlign(LEFT);
             fill (128,0,0);
             textSize(30);
             text("Alvos Destruidos.. " + pontos,33 ,(height/2)-250);
             fill (25,25,112);
             text("Período.. " + nivel,33,(height/2)-220); //Precisa ser modificado
            
            //ATUALIZAÇÃO DO RECORDE GERAL EM TEMPO REAL
            recordeAtual = pontos;
            if (recordeAtual >= recordeTotal){
                recordeTotal = recordeAtual;
            }
            
            textSize(30);
            fill(25,25,112);
            text("Recorde Geral..  " + recordeTotal, telaCompleta-240, telaCompleta2);
             //****************** AUMENTAR A VELOCIDADE ************************
             if (pontos > 30 && pontos <100)//aumenta a velocidade dos alvos baseado na pontuacao atual
               velocidade=2;
             else if (pontos >= 100)
               velocidade=3;

            }
            
        //DEFINE QUAL PERIODO - BASEADO NA QUANTIDADE DE ELIMINAÇÕES
        //definePeriodo(pontos);
        
        if (perdeu==true){ //se algum alvo chegar ate o fim da tela, perde-se o jogo
            recordeAtual = pontos;
            if (recordeAtual >= recordeTotal){
                recordeTotal = recordeAtual;
            }
            
        nivel = 1;
        FreeFire.pause();
        somTiro.pause();
        backgroundGameOver.resize(600, 600);
        //background(backgroundGameOver);
        background(0);
        image(backgroundGameOver, 200, 0);
        
        textFont(font48);
        fill(255,0,0);
        text("Alvos Destruídos..  " + pontos, (width/2)-180, (height/2-220));
        
        textSize(30);
        fill(0,191,255);
        text("Recorde Geral..  " + recordeTotal, telaCompleta-240, telaCompleta2);
        if (keyPressed){
            if (key == ' ')
            setup();
        }
      }
    }
    
    void telaInicial (){
        print("Coordenada X: ",  mouseX + "\n");
        print("Coordenada Y: ",  mouseY + "\n");
        print("\n");       
        
       //Verifica botao Iniciar 

          fundoInicio.resize(1000, 600);
          background(fundoInicio); 
          
          botao1Iniciar();
          botao2Creditos();
          botao3Sair();
          
          startIniciar();
          startCredito();
          startSair();
          tutorialAcao();
    }
    
    public void startIniciar (){
        //Coordenadas botao 1 - Iniciar (Verifica se houve clique dentro do botao Iniciar)
        if (mouseX >= 405 && mouseX <= 590 && mouseY >= 260 && mouseY <= 340 && mousePressed) {
          botao1 = true;
        } else if (keyPressed){
            if (key == 'i' || key == 'I'){ //Apertar 'i' para iniciar o jogo
                botao1 = true;
            }
        }
    }
    
    void botao1Iniciar (){
        image(botaoIniciarVazio, (width/2)-100, (height/2)-50);
        //image(imagemStart, (width/2)-50, (height/2));
        botaoIniciarVazio.resize(200, 100);
        //imagemStart.resize(100,50);
        textFont(font48);
        fill(50,50,50);
        
        text("Iniciar", (width/2)-62,(height/2)+20);
    }
    
    public void startCredito(){
        //Coordenadas botao 2 - Creditos (Verifica se houve clique dentro do botao Creditos)
        if (mouseX >= 405 && mouseX <= 590 && mouseY >= 380 && mouseY <= 460 && mousePressed) {
          botao2 = true;
        } else if (keyPressed){
            if (key == 'c' || key == 'C'){ //Apertar 'c' para creditos
                botao1 = true;
            }
        }
    }
    void botao2Creditos (){
        //****************** Aparência e localização ***************************
        image(botaoIniciarVazio, (width/2)-100, (height/2)+70);
        //image(imagemStart, (width/2)-50, (height/2));
        botaoIniciarVazio.resize(200, 100);
        
        textFont(font48);
        fill(50,50,50);
        
        text("Créditos", (width/2)-78,(height/2)+140);

        //**********************************************************************
    }
    void acaoBotao2Creditos(){
        image(imagemCreditos, (width/2)-400, (height/2)-100);
        imagemCreditos.resize(280, 350);
        print("CREDITOS\n");
    }
    
    void tutorialAcao (){
        image(tutorialInicio, (width/2)+120, (height/2)-50);
        tutorialInicio.resize(300, 200);
    }
    
    void botao3Sair(){
        //image(botaoIniciarVazio, (width/2)+290, (height/2)+190);
        //image(imagemStart, (width/2)-50, (height/2));
        //botaoSair.resize(100, 50);
        textFont(font48);
        fill(255,0,0);
        
        text("Sair..", (width/2)+370,(height/2)+280);
    }
    
    void startSair(){
        //Coordenadas botao 3 - Sair (Verifica se houve clique em cima do nome SAIR)
        if (mouseX >= 865 && mouseX <= 965 && mouseY >= 540 && mouseY <= 580 && mousePressed) {
          botao3 = true;
        } 
    }
    
    private void ConfirmarSaida(){ //Ainda nao está certo
        JOptionPane sair = new JOptionPane();
        ImageIcon icon = new ImageIcon("src/vetores/logo3.png");
        int Sair = sair.showConfirmDialog(null,"Você deseja sair do JOGO?","Sair",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
      if(Sair == JOptionPane.YES_OPTION){
        System.exit(0);
       this.dispose();

      }/*else{
         if(Sair == JOptionPane.NO_OPTION){
            sair.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         }
      }*/


}
    void menupausa() { // NAO ESTÁ SENDO USADO  
        textSize(30);
        fill(0);
        text("! PAUSADO !  ", width/4, height/2);
        text("Aperte P para Voltar", width/2 -100, height/2 + 80);
    }   
    
    void escreveVersao(){
        //textSize(15);
        fill(192,192,192);
        textFont(font32, 20);
        text("Versão 1.0.0  ", (width/10)-90, (height - 10));
    }
        
    class Alvos {
        int x, y, lado, movy;
        boolean checar;
        int alvoAleatorio=0;

        Alvos(int x_, int y_, int lado_, int movy_, boolean checar_){
          x=x_;
          y=y_;
          lado=lado_;
          movy=movy_;
          checar=checar_;
        }

        public void desenhaAlvo(int alvoAleatorio){
          if (!checar){
            y=y+movy;
            //rect(x,y,lado,lado); //Desenha os quadrados
            
            if (alvoAleatorio == 1){
                image(imagemOnibus, x, y);
                imagemOnibus.resize(100,100);
            }
            if (alvoAleatorio == 2 ){
                image(carteiraVazia, x, y);
                carteiraVazia.resize(75,75);  
            }
            if (alvoAleatorio == 3){
                image(python, x, y);
                python.resize(90,90);
            }
            if (alvoAleatorio == 4 ){
                image(imagemArquitetura, x, y);
                imagemArquitetura.resize(75,90);
            }
            if (alvoAleatorio == 5 ){
                image(imagemCalculo, x, y);
                imagemCalculo.resize(75,90);
            }
            if (alvoAleatorio == 6 ){
                image(aspectos, x, y);
                aspectos.resize(75,90);
            }
            if (alvoAleatorio == 7 ){
                image(cCompletoTotal, x, y);
                cCompletoTotal.resize(75,90);
            }
            if (alvoAleatorio == 8 ){
                image(imagemEletromag, x, y);
                imagemEletromag.resize(75,90);
            }
            if (alvoAleatorio == 9 ){
                image(java, x, y);
                java.resize(75,90);
            }
            if (alvoAleatorio == 10 ){
                image(ia, x, y);
                ia.resize(90,90);
            }
            if (alvoAleatorio == 11 ){
                image(so, x, y);
                so.resize(75,90);
            }
            if (alvoAleatorio == 12 ){
                image(bd, x, y);
                bd.resize(75,90);
            }
            if (alvoAleatorio == 13 ){
                image(compiladores, x, y);
                compiladores.resize(75,90);
            }
            if (alvoAleatorio == 18 ){
                image(sistemaMultimidia, x, y);
                sistemaMultimidia.resize(75,90);
            }
            if (alvoAleatorio == 14 ){
                image(grafos, x, y);
                grafos.resize(75,90);
            }
            if (alvoAleatorio == 15 ){
                image(tcc, x, y);
                tcc.resize(75,90);
            }
            if (alvoAleatorio == 16 ){
                image(facebook, x, y);
                facebook.resize(90,90);
            }
            if (alvoAleatorio == 19 ){
                image(google, x, y);
                google.resize(90,90);
            }
          }
          if (y-lado/2 > height){ //Verificação se o objeto saiu da janela (PERDEU)
            perdeu= !perdeu;
          }
        }
    }    

    public class Jogo {
        PVector local;
        Jogo(){
            local = new PVector(width/2, height-20);
        }

    void atualiza() {
      if (mousePressed == true){
        if (atirar == true){
          tiros.add( new Tiro());
          atirar = false;
          recarga = 0;
        }
      }

      if (atirar == false){//verifica se o personagem recarregou 
        recarga++;
        if (recarga == 15){//limita o numero de tiros por tempo
          atirar = true;
        }
      }
    }
  }
    void miraMouse(){
        fill(255, 0, 0);
        rect(mouseX - 1, mouseY - 1, 2, 2);
        //drawing crosshair
        rect(mouseX + 5, mouseY - 1, 10, 2);
        rect(mouseX - 1, mouseY + 5, 2, 10);
        rect(mouseX - 15, mouseY - 1, 10, 2);
        rect(mouseX - 1, mouseY - 15, 2, 10);
    }
    
    void gameon(){

         fundoInicio.resize(1000, 600);
         background(fundoInicio); //Senao fica o fundo preto
         
         //Chuva durante a partida
         /*for (Drop drop : drops) {
            drop.fall();
            drop.show();           
        }*/
    }
    

    
    class Player {
            PVector pos = new PVector(100, height/2);
            int vida = 100;
            boolean escudo = false;
            float velocidade =8;

            void desenhaPersonagem(){            
               image(imagemPersonagemPrincipal, (width/2)+x, (height/2)+y);                
            }
            
            void movimentar(){ //Movimentação do personagem principal
                if (keyPressed ){
                    if (key == 'w' || key == 'W'){
                        y = y -10;
                    }
                    if (key == 's' || key == 'S'){
                        y = y+10;
                    }
                    if (key == 'd' || key == 'D'){
                        x = x+10;
                    }
                    if (key == 'a' || key == 'A'){
                        x = x-10;
                    }
                    if (key == CODED){
                        if (keyCode == UP  ) {                   
                            subir = true;
                            y = y -10;
                        }

                        if (keyCode == DOWN) {
                            descer = true;
                            y = y+10;
                        }
                        if (keyCode == RIGHT) {
                            direita = true;
                            x = x +10;
                        }
                        if (keyCode == LEFT) {
                            esquerda = true;
                            x = x -10;
                        }
                    }   
                    
                    if ((x+metadeTela1) <= 0){ //Bordas (Esquerda)
                        x = x+10;
                    }
                    if ((x+metadeTela1) >= width -100){
                        x = x-10;
                    }
                    if ((y+metadeTela2) <= 0){ //Bordas (Cima)
                        y = y +10;
                    }
                    if ((y+metadeTela2)>= height-100){
                        y = y -10;
                    }
                }         
            }
            
    }

  
  //Chuva do fundo
  class Drop{
      float x1 = random(width), y1 = random(-200, -100);
      float yspeed = random(3, 10);
      float len = random(10, 20);
      
      void fall (){
        y1 = y1 + yspeed;
        yspeed = (float) (yspeed + 0.05);
        
        if (y1 > height){
            y1 = random(-200,-100);
            yspeed = random(4,10);
        }
      }
      void show(){
        stroke(138, 43, 226);
        line(x1, y1, x1, y1+len);
      }
  }
  
  public class Tiro {
  PVector local;
  float PosAntigaX, PosAntigaY, angulo;
  Tiro(){
    local= new PVector(width/2, height -20); //Local onde está saindo os tiros
    //descobre o angulo
    PosAntigaX = mouseX;
    PosAntigaY = mouseY;
    angulo = atan2(PosAntigaY - local.y, PosAntigaX - local.x) / PI * 180;

    /*if (angulo > -45) //limitacao da mira para a direita
      angulo= -45;
    if (angulo < -135) //limitacao de mira para a esquerda
      angulo= -135;*/
  }
  
  void atualiza(){ //atualiza a posicao do tiro
    local.x = local.x + cos(angulo/180*PI)*10; //Velocidade dos tiros
    local.y = local.y + sin(angulo/180*PI)*10; //Velocidade dos tiros
    rect(local.x, local.y, 10, 10,3); //Objeto do tiro

    //apaga o tiro se saiu da tela
    if ((local.x < 0 || local.x > width) && (local.y < 0)) {
      tiros.remove(i);
    }
    
    Colisao(); //chama a funcao de colisao
  }
  
    public void Colisao(){ //testa a colisao dos tiros com o alvo para fazer os alvos sumirem.
        //VERIFICA COLISÃO
        for (int c=0; c<alvo.length; ++c){
            if (alvo[c].checar==false){
                if (local.y <= alvo[c].y + alvo[c].lado/2 && local.y >= alvo[c].y - alvo[c].lado/2){
                  if (local.x >= alvo[c].x-alvo[c].lado/2 && local.x <= alvo[c].x + alvo[c].lado/2){
                    alvo[c].checar=true;//apaga o alvo e o tiro se colidiram.
                    tiros.remove(i);
                    pontos++;
                  }
                }
            }
        }     
    }
  }
 
  // ********************** DEFINE OS PERÍODOS ***************************
  void definePeriodo (int alvosDestruidos){
        if(alvosDestruidos == 5){ 
            nivel=2;
        }
        if (alvosDestruidos == 11){
            nivel=3;
        }
        if (alvosDestruidos == 17){
            nivel=4;
        }
        if(alvosDestruidos == 23){
            nivel=5;
        }
        if (alvosDestruidos == 30){
            nivel=6;
        }
        if (alvosDestruidos == 37){
            nivel=7;
        }
        if (alvosDestruidos == 44){
            nivel=8;
        }
        if (alvosDestruidos == 50){
            nivel=9;
        }
        if (alvosDestruidos >= 56){
            nivel=10;
        }
        
        
  }
}

