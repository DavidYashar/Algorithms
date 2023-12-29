class Node {
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    constructor(){
        this.root = null
    }

    addNode(node){
        if(!this.root){
            this.root = node;

        } else {
            let current = this.root;

            while(true){
                if (node.data < current.data){
                    if(current.left === null){
                        current.left = node;
                        break;
                    }
                    current = current.left
                } else if(node.data > current.data) {
                    if(current.right === null){
                        current.right = node;
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

    hasNode(data){
        if(!this.root){
            return false;
        } else {
            let current = this.root;

            while(current !== null){
                if(data === current.data){
                    return true
                } else if(data < current.data){
                    current = current.left
                } else {
                    current = current.right
                }
            }
            return false
        }
    }
}
