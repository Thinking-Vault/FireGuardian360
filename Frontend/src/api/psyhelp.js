import { Client } from '@stomp/stompjs';

export function initChat(onMessage) {
    const client = new Client({brokerURL:'ws://localhost:8080/chat-websocket',connectHeaders:{},debug:()=>{},reconnectDelay:1000});
    client.onConnect = () => {
        client.subscribe('/topic/messages', (msg) => onMessage(JSON.parse(msg.body)));
    };
    client.activate();
    return client;
}
export async function startSession(userId) {
    const res = await fetch('/psyhelp/session', {method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify({userId})});
    return await res.json();
}
export function sendMessage(client, message) {
    client.publish({destination:'/app/chat.send',body:JSON.stringify(message)});
}