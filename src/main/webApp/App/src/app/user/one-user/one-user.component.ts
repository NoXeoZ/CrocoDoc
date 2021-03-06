import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../../model/user";
import {UserService} from "../user.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";

@Component({
  selector: 'tr [user]',
  templateUrl: './one-user.component.html',
  styleUrls: ['./one-user.component.css']
})
export class OneUserComponent implements OnInit {
  @Input()
  user: User;

  @Output()
  deleteUser = new EventEmitter<User>();
  private key: string;
  constructor(private userService: UserService,private route :ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.key = this.route.snapshot.params['key'];
  }
  onDeleteUser(id: any){
    this.userService
      .deleteUser(this.user.id,this.key)
      .subscribe(
        data=> {
          this.deleteUser.emit(this.user);
          this.router.navigateByUrl("/home");
        },
        error => {console.log(error);
        })}
}
