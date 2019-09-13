import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-help',
  templateUrl: './help.component.html',
  styleUrls: ['./help.component.css']
})
export class HelpComponent implements OnInit {
  images = [
    { img: "/assets/images/help.png"  },
    { img: "/assets/images/help.png"  },
    { img: "/assets/images/help.png"  },
    { img: "/assets/images/help.png"  },
    { img: "/assets/images/help.png"  },
    { img: "/assets/images/help.png"  }
   ];
  constructor() { }

  ngOnInit() {
  }

}
