class Bubble{
    x: number;
    y: number;
    letter: string;
    speed: number;
    
    static radius: number = 20;
    alive: boolean = true;

    constructor(x: number, y: number, letter: string, speed: number){
        this.x = x;
        this.y = y;
        this.letter = letter;
        this.speed = speed;
    }

    update(): void {
        this.y += this.speed;
    }

    draw(): void {
        fill(255);
        stroke(255);
        circle(this.x, this.y, 2 * Bubble.radius);
        fill(0);
        stroke(0);
        textSize(15);
        text(this.letter, this.x - 5, this.y + 5);
    }
}

class Board{
    bubbles: Bubble[] = [];
    timeout: number = 30;
    timer: number = 0;
    hits = 0;
    mistakes = 0;
    nivel = 1;

    constructor(){
        this.bubbles = [new Bubble(100, 100, "a", 1)];
        this.bubbles.push(new Bubble(200, 100, "b", 2));
        this.bubbles.push(new Bubble(300, 100, "c", 3));
    }

    update(): void {
        this.checkBubbleTime();
        this.markOutsideBubbles();
        this.checkNivel();

        for (let bubble of this.bubbles)
            bubble.update();
        this.removeDeadBubbles();
    }

    removeDeadBubbles(): void {
        this.bubbles = this.bubbles.filter(b => b.alive);

    }

    removeByHit(code: number): void {
        for(let bubble of this.bubbles){
            if(bubble.letter[0].toUpperCase().charCodeAt(0) == code){
              bubble.alive = false;
              this.hits++;
              break;
            }
    
        }
    }

    checkNivel(): void {
        if(this.hits > 10)
            this.nivel = 2;
        if(this.hits > 20)
            this.nivel = 3;
         if(this.hits > 30)
            this.nivel = 4;
        if(this.hits > 40)
            this.nivel = 5;
        if(this.hits > 50)
            this.nivel = 6;
         if(this.hits > 60)
            this.nivel = 7;
        if(this.hits > 70)
            this.nivel = 8;
        if(this.hits > 80)
            this.nivel = 9;
         if(this.hits > 90)
            this.nivel = 10;
        if(this.hits > 100)
            this.nivel = 10;
    }

    checkBubbleTime(): void{
        this.timer -= 1;
        if(this.timer <= 10){
            this.addBubble();
            this.timer = this.timeout;
        }
    }

    markOutsideBubbles(): void {
        for (let bubble of this.bubbles)
        if(bubble.y + 2 * Bubble.radius >= height){
        bubble.alive = false;
            this.mistakes++;
        }
    }

    addBubble(): void{
        let x = random(0, width - 2 * Bubble.radius);
        let y = -2 * Bubble.radius;
        let letter = random(["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]);
        let speed = this.nivel;
        let bubble = new Bubble(x, y, letter, speed);
        this.bubbles.push(bubble);
    }

    draw(): void {
        stroke("white");
        fill("white");
        textSize(30);
        text("hits: " + this.hits + " mistakes :" + this.mistakes + " ativas: " + this.bubbles.length + " level: " + this.nivel, 30, 30);

        for (let bubble of this.bubbles)
            bubble.draw();
    }

}

class Game{
    board: Board;
    activeState: () => void;
    constructor(){
        this.board = new Board();
        this.activeState = this.gamePlay;
    }

    gamePlay(): void {
        this.board.update();
        background(50, 50, 50);
        this.board.draw();
        if (this.board.mistakes > 5)
            this.activeState = this.gameOver;
        if (this.board.hits > 120)
            this.activeState = this.gameWin
    }

    gameOver(): void {
        background(250, 0, 0);
        fill(0);
        textSize(100);
        text("Game Over", 125, 300);
        textSize(40);
        text("press space to play", 200, 500);
    }

    gameWin(): void {
        background(0, 255, 0);
        fill(0);
        textSize(100);
        text("Game Win", 125, 300);
        textSize(40);
        text("press space to play", 200, 500);
    }
}

let game: Game;

function setup() {
    createCanvas(800, 600);
    frameRate(30);
    game = new Game();
}

function keyPressed() {
    game.board.removeByHit(keyCode);
}

function draw(){
    game.activeState();
}